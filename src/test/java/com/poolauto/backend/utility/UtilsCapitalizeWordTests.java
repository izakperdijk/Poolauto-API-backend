package com.poolauto.backend.utility;

import org.junit.jupiter.api.Test;

import static com.poolauto.backend.utility.Util.capitalizeWord;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsCapitalizeWordTests {

    @Test
    public void capitalizeVoornaam() {
        assertEquals("Voornaam", capitalizeWord("voornaam"));
    }

    @Test
    public void fixCapsLock() {
        assertEquals("Captur", capitalizeWord("CAPTUR"));
    }

    @Test
    public void capitalizeSentenceAsASingleWord() {
        assertEquals("Capitalized sentence as if it were a single word",
                capitalizeWord("capitaliZed Sentence as if it were a SINGLE word"));
    }

}
