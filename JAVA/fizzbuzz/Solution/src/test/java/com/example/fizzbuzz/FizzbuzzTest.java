package com.example.fizzbuzz;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FizzbuzzTest {
    FizzBuzz fizzbuzz;

    @BeforeEach
    void beforeEach() {
        fizzbuzz = new FizzBuzz();
    }

    @Test
    void getsFizzIfNumberIsMultipleOf3() {
        assertEquals("Fizz", fizzbuzz.transform(3));
    }

    @Test
    void getsFizzIfNumberIsMultipleOf5() {
        assertEquals("Buzz", fizzbuzz.transform(5));
        assertEquals("Buzz", fizzbuzz.transform(10));
    }


    @Test
    void getFizzBuzzIfNumberIsMultipleOf5And3() {
        assertEquals("FizzBuzz", fizzbuzz.transform(30));
    }

    @Test
    void getsSameNumberIfNotMultipleOf5Or3() {
        assertEquals("8", fizzbuzz.transform(8));
    }

}
