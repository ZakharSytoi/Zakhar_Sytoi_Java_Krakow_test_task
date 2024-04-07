package org.testtask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testtask.util.JsonConfigurationFileProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class JsonParserTest {

    private final JsonParser jsonParser = new JacksonJsonParser();

    @Test
    @DisplayName("Parsing valid configuration should return Map with valid values corresponding to keys")
    void givenValidConfiguration_whenParseJsonConfiguration_thenReturnFullyValidValues() throws IOException {
        // given
        File file = JsonConfigurationFileProvider.getValidConfigurationFile();
        Map<String, HashSet<String>> expected = getExpectedConfiguration();

        // when
        Map<String, HashSet<String>> result = jsonParser.parseJsonConfiguration(file);

        // then
        assertConfigurationEquals(expected, result);
    }



    private Map<String, HashSet<String>> getExpectedConfiguration() {
        Map<String, HashSet<String>> expected = new HashMap<>();
        expected.put("Cookies Oatmeal Raisin", new HashSet<>(List.of("Pick-up point", "Parcel locker")));
        expected.put("Cheese Cloth", new HashSet<>(List.of("Courier", "Parcel locker", "Same day delivery", "Next day shipping", "Pick-up point")));
        expected.put("English Muffin", new HashSet<>(List.of("Mailbox delivery", "Courier", "In-store pick-up", "Parcel locker", "Next day shipping", "Express Collection")));
        expected.put("Ecolab - Medallion", new HashSet<>(List.of("Mailbox delivery", "Parcel locker", "Courier", "In-store pick-up")));
        return expected;
    }

    private void assertConfigurationEquals(Map<String, HashSet<String>> expected, Map<String, HashSet<String>> result) {
        Assertions.assertEquals(expected.size(), result.size(), "Map sizes should be equal");

        for (String key : expected.keySet()) {
            Assertions.assertTrue(result.containsKey(key), "Key not found in result map: " + key);
            Assertions.assertEquals(expected.get(key), result.get(key), "Values mismatch for key \"" + key + "\"");
        }
    }
}