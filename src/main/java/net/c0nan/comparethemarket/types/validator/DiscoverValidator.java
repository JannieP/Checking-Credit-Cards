package net.c0nan.comparethemarket.types.validator;

import net.c0nan.comparethemarket.types.AbstractCardValidator;
import net.c0nan.comparethemarket.types.CardTypeValidator;

public class DiscoverValidator extends AbstractCardValidator implements CardTypeValidator {

    /*
    * Starts with 6011, then any 12 digits
    * Total 16 digits
    */
    public static final String VALIDATOR_REGEX_PATTERN = "^6011[0-9]{12}$";
    public static final String VALIDATOR_ISA_PATTERN = "^6011.*$";

    @Override
    protected String getValidatorPattern() {
        return VALIDATOR_REGEX_PATTERN;
    }

    @Override
    protected String getIsAPattern() {
        return VALIDATOR_ISA_PATTERN;
    }
}
