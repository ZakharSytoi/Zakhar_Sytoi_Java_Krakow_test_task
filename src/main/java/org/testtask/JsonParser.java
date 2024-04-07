package org.testtask;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

interface JsonParser {
    Map<String, HashSet<String>> parseJsonConfiguration(File file) throws IOException;
}
