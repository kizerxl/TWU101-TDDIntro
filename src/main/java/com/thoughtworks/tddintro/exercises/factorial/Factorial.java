package com.thoughtworks.tddintro.exercises.factorial;

public class Factorial {
    public Integer compute(int i) throws IllegalArgumentException {
        if(i < 0) {
            throw new IllegalArgumentException();
        }

        if(i == 0) {
            return 1;
        }

        int result = 1;
        for(int num = i; num > 0; num--) {
            result *= num;
        }

        return result;
    }
}
