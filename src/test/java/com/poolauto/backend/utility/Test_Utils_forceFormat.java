package com.poolauto.backend.utility;

import org.junit.jupiter.api.Test;

import static com.poolauto.backend.utility.Util.forceFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test_Utils_forceFormat { // Illegal format on input

    @Test // To uppercase
    public void forceCapitalization() {
        assertEquals("SJ740T", forceFormat("sj740t"));
        assertEquals("SJ740T", forceFormat("sJ740t"));
        assertEquals("SJ740T", forceFormat("sj740T"));
        assertEquals("SJ740T", forceFormat("Sj740t"));
    }

    @Test // Input is too short
    public void illegalFormatMinLength() {
        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj740"));
        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj74)"));
    }

    @Test // Input is non-alphanumeric
    public void illegalFormatNonAlphanumeric() {

        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj@#()"));
        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj)40T"));
    }

    @Test // Input is too long
    public void illegalFormatMaxLength() {
        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj740Tt"));
        assertThrows(IllegalArgumentException.class, () -> forceFormat("sj740t@"));
        assertThrows(IllegalArgumentException.class, () -> forceFormat("!SJ740T"));
    }
}
