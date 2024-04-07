package org.testtask;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
        return null;
    }


}
