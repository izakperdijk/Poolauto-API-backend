package com.poolauto.backend.utility;

import org.junit.jupiter.api.Test;

import static com.poolauto.backend.utility.Util.enforceFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/* Test for (il)legal format on input value */
public class UtilsEnforceFormatTests {

    @Test // To uppercase
    public void forceCapitalization() {
        assertEquals("XX999X", enforceFormat("xx999x"));
        assertEquals("XX999X", enforceFormat("xX999x"));
        assertEquals("XX999X", enforceFormat("xx999X"));
        assertEquals("XX999X", enforceFormat("Xx999x"));
    }

    @Test // Remove dashes (if valid format; containing two dashes)
    public void removeDashes() {
        assertEquals("XX999X", enforceFormat("XX-999-X"));
        assertEquals("XXX99X", enforceFormat("XXX-99-X"));
        assertEquals("X999XX", enforceFormat("X-999-XX"));
        assertEquals("X999XX", enforceFormat("x-999-xx"));
    }

    @Test // Input is too short (min length 6, not counting dashes)
    public void illegalFormatMinLength() {
        // No dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx999"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx99)"));
        // Dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx-99-X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx-99-@"));
    }

    @Test // Input is non-alphanumeric
    public void illegalFormatNonAlphanumeric() {
        // No dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx@#()"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx)99X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("@!#$%^"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("éµãßœ∑"));
        // Dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx)-99-X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx-99@-X"));
    }

    @Test // Input is too long (max length 6, not counting dashes)
    public void illegalFormatMaxLength() {
        // No dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx999Xx"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("xx999x@"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("!XX999X"));
        // Dashes
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("!XX-999-X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XXX-999-X"));
    }

    @Test
    public void illegalFormatTooManyDashes() {
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XXX--99-X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("-------X"));
    }

    @Test
    public void illegalFormatNotEnoughDashes() {
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XX999-X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XX-999X"));
    }

    @Test
    public void illegalFormatTwoDashesConsecutively() {
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XXX--99X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("X--XX99X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XXX99--X"));
    }

    @Test
    public void illegalFormatStartsOrEndsWithDash() {
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("-XXX-99X"));
        assertThrows(IllegalArgumentException.class, () -> enforceFormat("XXX-99X-"));
    }

}
