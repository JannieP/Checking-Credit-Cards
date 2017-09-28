package net.c0nan;

import net.c0nan.comparethemarket.CardProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardProcessorTest {
    @Before
    public void setup() {
    }

    @Test
    public void testCardProcessor() throws Exception {

        Assert.assertTrue(new CardProcessor().processCard("4111111111111111"));
        Assert.assertFalse(new CardProcessor().processCard("4111111111111"));
        Assert.assertTrue(new CardProcessor().processCard("4012888888881881"));
        Assert.assertTrue(new CardProcessor().processCard("378282246310005"));
        Assert.assertTrue(new CardProcessor().processCard("6011111111111117"));
        Assert.assertTrue(new CardProcessor().processCard("5105105105105100"));
        Assert.assertFalse(new CardProcessor().processCard("5105 1051 0510 5106"));
        Assert.assertFalse(new CardProcessor().processCard("9111111111111111"));

    }

}
