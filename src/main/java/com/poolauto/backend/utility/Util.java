package com.poolauto.backend.utility;

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

}
