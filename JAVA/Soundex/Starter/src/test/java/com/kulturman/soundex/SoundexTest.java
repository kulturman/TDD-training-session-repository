package com.kulturman.soundex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundexTest {
    Soundex soundex;

    @BeforeEach
    void beforeEach() {
        soundex = new Soundex();
    }

    @Test
    void retainsFirstLetterOfOneLetterWord() {
        assertEquals("A000", soundex.encode("A"));
    }

    @Test
    void uppercaseFirstLetter() {
        assertEquals("A000", soundex.encode("a"));
    }

    @Test
    void addsWordWithZeros() {
        assertEquals("B000", soundex.encode("B"));
    }

    @Test
    void replacesConsonantWithCorrectLetter() {
        assertEquals("B200", soundex.encode("BC"));
    }

    @Test
    void replacesMultipleConsonantsWithTheirValues() {
        assertEquals("B210", soundex.encode("BCF"));
    }

    @Test
    void encodesAdjacentLettersThatEncodeToTheSameDigitOnce() {
        assertEquals("C500", soundex.encode("CMN"));
    }

    @Test
    void encodedValueShouldBeOfSize4() {
        assertEquals("C546", soundex.encode("CMLRP"));
    }

    @Test
    void getsRidOfVowelsPlusWAndH() {
        assertEquals("C000", soundex.encode("CH"));
    }
}
