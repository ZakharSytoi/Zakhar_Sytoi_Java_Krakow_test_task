package org.testtask;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testtask.exception.ProductNotExistsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BasketSplitterTest {

    private final BasketSplitter basketSplitter;

    public BasketSplitterTest() throws IOException {
        basketSplitter = new BasketSplitter("src/test/resources/config.json");
    }

    static Stream<Arguments> validItemsProvider() {
        List<String> items1 = List.of("Fond - Chocolate");

        List<String> items2 = List.of("Cocoa Butter",
                "Tart - Raisin And Pecan",
                "Fond - Chocolate",
                "Table Cloth 54x72 White",
                "Flower - Daisies",
                "Cookies - Englishbay Wht");

        List<String> items3 = List.of("Garlic - Peeled",
                "Spinach - Frozen",
                "Cake - Miini Cheesecake Cherry",
                "Chickhen - Chicken Phyllo");

        Map<String, List<String>> expected1 = new HashMap<>();
        expected1.put("Pick-up point", List.of("Fond - Chocolate"));


        Map<String, List<String>> expected2 = new HashMap<>();
        expected2.put("Pick-up point", List.of("Fond - Chocolate"));
        expected2.put("Courier", List.of("Cocoa Butter",
                "Tart - Raisin And Pecan",
                "Table Cloth 54x72 White",
                "Flower - Daisies",
                "Cookies - Englishbay Wht"));

        Map<String, List<String>> expected3 = new HashMap<>();
        expected3.put("Pick-up point", List.of("Chickhen - Chicken Phyllo"));
        expected3.put("Courier", List.of("Cake - Miini Cheesecake Cherry"));
        expected3.put("Mailbox delivery", List.of("Spinach - Frozen"));
        expected3.put("Same day delivery", List.of("Garlic - Peeled"));


        return Stream.of(
                arguments(items1, expected1),
                arguments(items2, expected2),
                arguments(items3, expected3)
        );
    }

    @ParameterizedTest
    @MethodSource("validItemsProvider")
    void givenValidItems_whenSplit_thenReturnedCorrectResult(List<String> items, Map<String, List<String>> expected) throws Exception {
        // when
        Map<String, List<String>> result = basketSplitter.split(items);

        // then
        for (String key : expected.keySet()) {
            assertEquals(expected.get(key), result.get(key));
        }
        for (String key : result.keySet()) {
            assertEquals(expected.get(key), result.get(key));
        }
    }

    @Test
    void givenItemsWithNonExistingItem_whenSplit_thenThrowProductNotExistsException() {
        // given
        List<String> items = List.of("Garlic - Peeled",
                "Milk Shake",
                "Cake - Miini Cheesecake Cherry",
                "Cinnamon Bun");

        // when and then
        assertThrows(ProductNotExistsException.class, () -> basketSplitter.split(items));
    }

    @Test
    void givenNoItems_whenSplit_thenReturnEmptyMap() throws Exception {
        // given
        List<String> items = new ArrayList<>();

        // when
        Map<String, List<String>> result = basketSplitter.split(items);

        // then
        assertTrue(result.isEmpty());
    }
}