package com.tulh.galaxy.processor;

import com.tulh.galaxy.error.ErrorMessage;
import com.tulh.galaxy.util.ConversionInputHolder;
import com.tulh.galaxy.util.GalaxyDigitsConverter;
import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.error.GalaxyDigitNotExistedError;
import com.tulh.galaxy.error.WrongRomanInputError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareMaterialProcessor implements SentenceProcessor {

    @Override
    public void process(String sentence) {
        Pattern pattern = Pattern.compile(SentenceType.COMPARE_MATERIAL.getPattern());
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String galaxyDigit1 = matcher.group(1);
            String material1 = matcher.group(2);
            String galaxyDigit2 = matcher.group(3);
            String material2 = matcher.group(4);
            try {
                int number1 = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit1);
                int number2 = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit2);
                if (ConversionInputHolder.getInstance().materialConversionRateMap.containsKey(material1) && ConversionInputHolder.getInstance().materialConversionRateMap.containsKey(material2)) {
                    if (number1 * ConversionInputHolder.getInstance().materialConversionRateMap.get(material1) ==
                            number2 * ConversionInputHolder.getInstance().materialConversionRateMap.get(material2)) {
                        System.out.println(String.format("%s %s has same Credits with %s %s",
                                galaxyDigit1, material1, galaxyDigit2, material2));
                    } else if (number1 * ConversionInputHolder.getInstance().materialConversionRateMap.get(material1) <
                            number2 * ConversionInputHolder.getInstance().materialConversionRateMap.get(material2)) {
                        System.out.println(String.format("%s %s has less Credits than %s %s",
                                galaxyDigit1, material1, galaxyDigit2, material2));
                    } else {
                        System.out.println(String.format("%s %s has more Credits than %s %s",
                                galaxyDigit1, material1, galaxyDigit2, material2));
                    }
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
