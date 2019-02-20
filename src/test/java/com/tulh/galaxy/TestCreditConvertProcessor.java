package com.tulh.galaxy;

import com.tulh.galaxy.error.ErrorMessage;
import com.tulh.galaxy.processor.CreditConvertProcessor;
import com.tulh.galaxy.util.ConversionInputHolder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class TestCreditConvertProcessor {
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        ConversionInputHolder.getInstance().galaxyNumberRomanMap.put("glob", "I");
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        outContent = new ByteArrayOutputStream();
    }

    @Test
    public void testCreditConvertProcessor() {
        String sentence = "glob glob Silver is 34 Credits";
        CreditConvertProcessor creditConvertProcessor = new CreditConvertProcessor();
        creditConvertProcessor.process(sentence);
        assertEquals(17d, ConversionInputHolder.getInstance().materialConversionRateMap.get("Silver"));
    }


    @Test
    public void testCreditConvertProcessorGalaxyDigitNotDefined() {
        String sentence = "glob blob Silver is 100 Credits";
        CreditConvertProcessor creditConvertProcessor = new CreditConvertProcessor();
        creditConvertProcessor.process(sentence);
        assertEquals(ErrorMessage.GALAXY_DIGIT_INPUT_NOT_EXISTED + "\r\n", outContent.toString());
    }


    @Test
    public void testCreditConvertProcessorRomanFormatInvalid() {
        String sentence = "glob glob glob glob Silver is 100 Credits";
        CreditConvertProcessor creditConvertProcessor = new CreditConvertProcessor();
        creditConvertProcessor.process(sentence);
        assertEquals(ErrorMessage.WRONG_INPUT_FORMAT_FOR_ROMAN_ASSIGNMENT + "\r\n", outContent.toString());
    }


}
