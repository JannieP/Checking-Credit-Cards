package net.c0nan.comparethemarket.types;

public interface CardTypeValidator {
    boolean validate(int cardDigits[]);

    boolean isA(int cardDigits[]);
}
