package com.poolauto.backend.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public interface Util {

    static String forceFormat(String input) {
        final String pattern = "[a-zA-Z0-9]{6}";
        if (!input.matches(pattern)) {
            throw new IllegalArgumentException();
        }
        return input.toUpperCase();
    }

    static String capitalizeWord(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    static void setProperties() throws IOException {
        // Get and set URL properties (RDW / Wiremock)
        FileInputStream propFile = new FileInputStream(
                System.getProperty("user.home") +
                        "/Desktop/" +
                        "poolautoAPI-Mock.properties"
        );

        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
    }
}
