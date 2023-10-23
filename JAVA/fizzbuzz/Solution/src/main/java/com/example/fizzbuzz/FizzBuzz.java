package com.example.fizzbuzz;

public class FizzBuzz {
    public String transform(int number) {
        if (isMulpipleOf3(number) && isMultipleOf5(number))
            return "FizzBuzz";
        if(isMulpipleOf3(number))
            return "Fizz";
        if (isMultipleOf5(number))
            return "Buzz";
        return String.valueOf(number);
    }

    private static boolean isMultipleOf5(int number) {
        return number % 5 == 0;
    }

    private static boolean isMulpipleOf3(int number) {
        return number % 3 == 0;
    }
}
