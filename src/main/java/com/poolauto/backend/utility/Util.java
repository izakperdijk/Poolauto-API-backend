package com.poolauto.backend.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Util {

    /* Validate and enforce correct format on input */
    static String enforceFormat(String input) {

        final Pattern patTwoDashes = Pattern.compile("^[a-zA-Z0-9]+-[a-zA-Z0-9]+-[a-zA-Z0-9]+$");   // f.i. XX-999-X
        final String patNoDashes = "[a-zA-Z0-9]{6}";                                                // f.i. XX999X
        Matcher m = patTwoDashes.matcher(input);

        if (m.matches()) {
            return enforceFormat(input.replace("-", ""));
        } else if (input.matches(patNoDashes)) {
            return input.toUpperCase();
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* Capitalize the first letter of a string, set all remaining letters to lowercase */
    static String capitalizeWord(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    /* Get and set URL properties (RDW / Wiremock) */
    static void setProperties() throws IOException {

        File parentDir = new File(System.getProperty("user.dir")).getParentFile();

        FileInputStream propFile = new FileInputStream(
                parentDir + "/poolautoAPI.properties"
        );

        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
    }
}
