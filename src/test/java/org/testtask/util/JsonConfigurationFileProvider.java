package org.testtask.util;

import java.io.File;

public class JsonConfigurationFileProvider {

    public static File getValidConfigurationFile(){
        return new File("src/test/resources/testConfigurations/validConfiguration.json");
    }

    public static File getInvalidJsonConfigurationFile(){
        return new File("src/test/resources/testConfigurations/invalidConfiguration.json");
    }

    public static File getInappropriateConfigurationFile(){
        return new File("src/test/resources/testConfigurations/inappropriateConfiguration.json");
    }

    public static File getNotExistingConfigurationFile(){
        return new File("");
    }
}
