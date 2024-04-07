package org.testtask;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class BasketSplitterConstructorTest {
    private BasketSplitter basketSplitter;
    private final String validConfigFilePath = "src/test/resources/testConfigurations/validConfiguration.json";
    private final String invalidConfigFilePath = "src/test/resources/testConfigurations/invalidConfiguration.json";
    private final String inappropriateConfigFilePath = "src/test/resources/testConfigurations/inappropriateConfiguration.json";
    private final String invalidFilePath = "";

    @Test
    @DisplayName("Constructor initializes BasketSplitter with valid config file path")
    public void givenValidConfigurationFilePath_whenConstructorCalled_thenBasketSplitterCreated() throws IOException {
        // when
        basketSplitter = new BasketSplitter(validConfigFilePath);

        // then
        assertNotNull(basketSplitter);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            invalidConfigFilePath,
            inappropriateConfigFilePath,
            invalidFilePath
    })
    @DisplayName("Constructor throws IOException for invalid config file path")
    public void givenInvalidConfigurationFilePath_whenConstructorCalled_thenThrowsException(String path) {
        // when

        //then
        assertThrows(IOException.class, () -> new BasketSplitter(invalidFilePath));
    }
}
