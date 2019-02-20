package com.tulh.galaxy.processor;

import com.tulh.galaxy.error.ErrorMessage;
import com.tulh.galaxy.util.GalaxyDigitsConverter;
import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.error.GalaxyDigitNotExistedError;
import com.tulh.galaxy.error.WrongRomanInputError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompareGalaxyNumberProcessor implements SentenceProcessor {
    @Override
    public void process(String sentence) {
        Pattern pattern = Pattern.compile(SentenceType.COMPARE_GALAXY_NUMBER.getPattern());
        Matcher matcher = pattern.matcher(sentence);
        while (matcher.find()) {
            String galaxyDigit1 = matcher.group(1);
            String galaxyDigit2 = matcher.group(2);
            try {
                int number1 = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit1);
                int number2 = GalaxyDigitsConverter.convertGalaxyDigitToNumber(galaxyDigit2);
                if (number1 == number2) {
                    System.out.println(String.format("%s is equal %s",
                            galaxyDigit1, galaxyDigit2));
                } else if (number1 < number2) {
                    System.out.println(String.format("%s is smaller than %s",
                            galaxyDigit1, galaxyDigit2));
                } else {
                    System.out.println(String.format("%s is larger than %s",
                            galaxyDigit1, galaxyDigit2));
                }
            } catch (GalaxyDigitNotExistedError e) {
                System.out.println(ErrorMessage.GALAXY_DIGIT_INPUT_NOT_EXISTED);
            } catch (WrongRomanInputError e) {
                System.out.println(ErrorMessage.WRONG_INPUT_FORMAT_FOR_ROMAN_ASSIGNMENT);
            }
        }
    }
}
