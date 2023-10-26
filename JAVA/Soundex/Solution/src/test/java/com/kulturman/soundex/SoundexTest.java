package com.kulturman.soundex;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SoundexTest {
    Soundex soundex;

    @BeforeEach
    void beforeEach() {
        soundex = new Soundex();
    }

    @Test
    void retainsFirsLetter() {
        assertEquals("A000", soundex.encode("A"));
    }

    @Test
    void uppercaseFirstLetter() {
        assertEquals("A000", soundex.encode("a"));
    }

    @Test
    void appendsZeros() {
        assertEquals("A000", soundex.encode("A"));
    }

    @Test
    void encodeConsonants() {
        assertEquals("E600", soundex.encode("ER"));
    }

    @Test
    void encodeMultipleConsonants() {
        assertEquals("E650", soundex.encode("ERM"));
    }

    @Test
    void resultIsLengthFour() {
        assertEquals(4, soundex.encode("ERMGN").length());
    }

    @Test
    void ignoreVoWelsAndHAndW() {
        assertEquals(soundex.encode("A"), soundex.encode("AE"));
    }

    @Test
    void encodesAdjacentLettersThatEncodesToTheSameDigitOnce() {
        assertEquals("A100", soundex.encode("ABBBBBB"));
    }
}
