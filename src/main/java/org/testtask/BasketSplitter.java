package org.testtask;


import org.testtask.exception.ProductNotExistsException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class BasketSplitter {


    private final Map<String, HashSet<String>> productsAndDeliveryMethods;
    private final BidirectionalMap<String, Integer> methodsOfDeliveryMapping;

    public BasketSplitter(String absolutePathToConfigFile) throws IOException {

        JsonParser jsonParser = new JacksonJsonParser();
        productsAndDeliveryMethods = jsonParser.parseJsonConfiguration(new File(absolutePathToConfigFile));
        methodsOfDeliveryMapping = new SimpleBidirectionalMap<>();

        int i = 0;
        for (Map.Entry<String, HashSet<String>> entry : productsAndDeliveryMethods.entrySet()) {
            for (String deliveryMethod : entry.getValue()) {
                if (!methodsOfDeliveryMapping.containsKey(deliveryMethod))
                    methodsOfDeliveryMapping.put(deliveryMethod, i++);
            }
        }
    }

    public Map<String, List<String>> split(List<String> items) throws Exception {
        Map<String, List<String>> splitItems = new HashMap<>();

        LinkedList<String> remainingItems = new LinkedList<>(items);

        while (remainingItems.size() > 0) {
            int[] arrayCountingItemsHandledByEachDeliveryMethod = new int[methodsOfDeliveryMapping.size()];

            for (String item : remainingItems) {
                if (productsAndDeliveryMethods.containsKey(item)) {
                    for (String deliveryMethod : productsAndDeliveryMethods.get(item)) {
                        arrayCountingItemsHandledByEachDeliveryMethod[methodsOfDeliveryMapping.get(deliveryMethod)]++;
                    }
                } else {
                    throw new ProductNotExistsException(String.format("Product %s not found.", item));
                }
            }

            String optimalDeliveryMethod = methodsOfDeliveryMapping.getKey(getMaxValueIndex(arrayCountingItemsHandledByEachDeliveryMethod));
            splitItems.put(optimalDeliveryMethod, new LinkedList<>());

            Iterator<String> remainingItemsIterator = remainingItems.iterator();

            while (remainingItemsIterator.hasNext()) {
                String item = remainingItemsIterator.next();
                if (productsAndDeliveryMethods.get(item).contains(optimalDeliveryMethod)) {
                    remainingItemsIterator.remove();
                    splitItems.get(optimalDeliveryMethod).add(item);
                }
            }
        }
        return splitItems;
    }

    private int getMaxValueIndex(int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
