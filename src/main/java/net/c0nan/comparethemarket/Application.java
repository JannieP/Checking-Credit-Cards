package net.c0nan.comparethemarket;

public class Application {
    public static void main(String args[]) {

        String[] listOfCards = new String[]{
                "4111111111111111",
                "4111111111111",
                "4012888888881881",
                "378282246310005",
                "6011111111111117",
                "5105105105105100",
                "5105 1051 0510 5106",
                "9111111111111111"};

        new CardProcessor().processCards(listOfCards);

    }
}
