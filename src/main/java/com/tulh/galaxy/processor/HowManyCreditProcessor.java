package com.tulh.galaxy.processor;

import com.tulh.galaxy.error.ErrorMessage;
import com.tulh.galaxy.error.GalaxyDigitNotExistedError;
import com.tulh.galaxy.error.WrongRomanInputError;
import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.util.ConversionInputHolder;
import com.tulh.galaxy.util.GalaxyDigitsConverter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HowManyCreditProcessor implements SentenceProcessor {
    @Override
    public void process(String sentence) {
        Pattern pattern = Pattern.compile(SentenceType.HOW_MANY_CREDITS.getPattern());
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String galaxyDigit = matcher.group(1);
            String material = matcher.group(2);
            try {
                int number = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit);
                if (ConversionInputHolder.getInstance().materialConversionRateMap.containsKey(material)) {
                    System.out.println(String.format("%s %s is %s Credits", galaxyDigit, material,
                            number * ConversionInputHolder.getInstance().materialConversionRateMap.get(material)));
                } else {
                    System.out.println(ErrorMessage.MATERIAL_IS_NOT_DEFINED);
                }
            } catch (GalaxyDigitNotExistedError e) {
                System.out.println(ErrorMessage.GALAXY_DIGIT_INPUT_NOT_EXISTED);
            } catch (WrongRomanInputError e) {
                System.out.println(ErrorMessage.WRONG_INPUT_FORMAT_FOR_ROMAN_ASSIGNMENT);
            }
        }
    }
}
