package net.c0nan.comparethemarket.validator;

public class Luhn {

    public static boolean validate(int digits[]) {
        int runningTotal = 0;
        int runningIndex = 0;

        for (int digitIndex = digits.length - 1; digitIndex >= 0; digitIndex--, runningIndex++) {
            int value = digits[digitIndex];
            if (runningIndex % 2 == 1) {
                if (value >= 5) {
                    value = (value * 2 - 10) + 1;
                } else {
                    value = value * 2;
                }
            }
            runningTotal += value;
        }
        return (runningTotal % 10) == 0;
    }

}
