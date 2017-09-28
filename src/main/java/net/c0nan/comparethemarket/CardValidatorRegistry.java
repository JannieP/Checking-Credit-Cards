package net.c0nan.comparethemarket;

import net.c0nan.comparethemarket.types.CardTypeValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class CardValidatorRegistry {

    private static Map<String, Class<? extends CardTypeValidator>> validators = new HashMap<>();

    public static Set<String> getValidatorsKeys() {
        return new HashMap<>(validators).keySet();
    }

    public static void addAll(Map<String, Class<? extends CardTypeValidator>> validators) {
        CardValidatorRegistry.validators.putAll(validators);
    }

    public static Class<CardValidatorRegistry> add(String name, Class<? extends CardTypeValidator> validator) {
        CardValidatorRegistry.validators.put(name, validator);
        return CardValidatorRegistry.class;
    }

    public static CardTypeValidator getValidatorInstance(String key) {
        Class<? extends CardTypeValidator> validatorClass = CardValidatorRegistry.validators.get(key);
        if (validatorClass == null) {
            return new InvalidCardValidator();
        }
        CardTypeValidator validator;
        try {
            validator = validatorClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return new InvalidCardValidator();
        }
        return validator;
    }

    public static class InvalidCardValidator implements CardTypeValidator {
        @Override
        public boolean validate(int[] cardDigits) {
            return false;
        }

        @Override
        public boolean isA(int[] cardDigits) {
            return false;
        }
    }


}
