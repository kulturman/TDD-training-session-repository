package com.kulturman.soundex;

import java.util.HashMap;
import java.util.Map;

public class Soundex {
    private static final int ENCODED_WORD_MAX_SIZE = 4;

    public String encode(String word) {
        var encodedWord = encodeWordTail(word, wordHead(word));

        return addZerosPadding(encodedWord);
    }

    private String encodeWordTail(String word, String encodedWord) {
        StringBuilder result = new StringBuilder(encodedWord);

        var wordTail = wordTail(word);
        var lastEncodedLetter = "";

        for (int i = 0; i < wordTail.length(); i++) {
            if (isComplete(result))
                break;

            if (doesNotEncodeToSameValue(wordTail.charAt(i), lastEncodedLetter)) {
                result.append(encodeLetter(wordTail.charAt(i)));
            }

            lastEncodedLetter = encodeLetter(wordTail.charAt(i));
        }

        return result.toString();
    }

    private boolean doesNotEncodeToSameValue(char letter, String lastEncodedLetter) {
        return !lastEncodedLetter.equals(encodeLetter(letter));
    }

    private boolean isComplete(StringBuilder result) {
        return result.length() == ENCODED_WORD_MAX_SIZE;
    }

    private static String wordTail(String word) {
        return word.substring(1);
    }

    private static String wordHead(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }

    String encodeLetter(char letter) {
        Map<String, String> soundexMap = new HashMap<>();

        soundexMap.put("b", "1");
        soundexMap.put("f", "1");
        soundexMap.put("p", "1");
        soundexMap.put("v", "1");

        soundexMap.put("c", "2");
        soundexMap.put("g", "2");
        soundexMap.put("j", "2");
        soundexMap.put("k", "2");
        soundexMap.put("q", "2");
        soundexMap.put("s", "2");
        soundexMap.put("x", "2");
        soundexMap.put("z", "2");

        soundexMap.put("d", "3");
        soundexMap.put("t", "3");

        soundexMap.put("l", "4");

        soundexMap.put("m", "5");
        soundexMap.put("n", "5");

        soundexMap.put("r", "6");

        return soundexMap.getOrDefault(String.valueOf(Character.toLowerCase(letter)), "");
    }

    String addZerosPadding(String encodedWord) {
        var zerosToAdd = ENCODED_WORD_MAX_SIZE - encodedWord.length();
        return encodedWord + "0".repeat(zerosToAdd);
    }
}
