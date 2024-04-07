package org.testtask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class JacksonJsonParser implements JsonParser{
    private static final TypeReference<HashMap<String, HashSet<String>>> JSON_CONFIGURATION_TYPE_REF = new TypeReference<>() {};

    public Map<String, HashSet<String>> parseJsonConfiguration(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, JSON_CONFIGURATION_TYPE_REF);
    }
}
