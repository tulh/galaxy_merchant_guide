package com.tulh.galaxy.processor;

import com.tulh.galaxy.error.ErrorMessage;
import com.tulh.galaxy.util.ConversionInputHolder;
import com.tulh.galaxy.util.GalaxyDigitsConverter;
import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.error.GalaxyDigitNotExistedError;
import com.tulh.galaxy.error.WrongRomanInputError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CreditConvertProcessor implements SentenceProcessor {
    @Override
    public void process(String sentence) {
        Pattern pattern = Pattern.compile(SentenceType.CREDIT_CONVERT.getPattern());
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String galaxyDigit = matcher.group(1);
            String material = matcher.group(2);
            Double credit = Double.valueOf(matcher.group(3));
            try {
                int amountOfMaterial = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit);
                ConversionInputHolder.getInstance().materialConversionRateMap.put(material, credit / amountOfMaterial);
            } catch (GalaxyDigitNotExistedError e) {
                System.out.println(ErrorMessage.GALAXY_DIGIT_INPUT_NOT_EXISTED);
            } catch (WrongRomanInputError e) {
                System.out.println(ErrorMessage.WRONG_INPUT_FORMAT_FOR_ROMAN_ASSIGNMENT);
            }
        }
    }
}
