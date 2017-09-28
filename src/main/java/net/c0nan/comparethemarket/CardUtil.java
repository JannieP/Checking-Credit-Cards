package net.c0nan.comparethemarket;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CardUtil {

    public static int[] parseToInt(String cardDigits) {
        return cardDigits.chars().map(x -> x - '0').toArray();
    }

    public static String parseToString(int[] cardDigits) {
        return Arrays.stream(cardDigits).mapToObj(String::valueOf).collect(Collectors.joining());
    }

}
