package com.tulh.galaxy.util;

import com.tulh.galaxy.error.GalaxyDigitNotExistedError;
import com.tulh.galaxy.error.WrongRomanInputError;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class GalaxyDigitsConverter {
    public static String romanNumberValidator = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

    public static int convertGalaxyDigitToNumber(String galaxyDigit) throws GalaxyDigitNotExistedError, WrongRomanInputError {
        List<String> galaxyDigits = Collections.list(new StringTokenizer(galaxyDigit, " ")).stream()
                .map(token -> (String) token)
                .collect(Collectors.toList());
        StringBuilder romanDigit = new StringBuilder();
        for (String digit : galaxyDigits) {
            if (!ConversionInputHolder.getInstance().galaxyNumberRomanMap.containsKey(digit)) {
                throw new GalaxyDigitNotExistedError();
            }
            romanDigit.append(ConversionInputHolder.getInstance().galaxyNumberRomanMap.get(digit));
        }
        return convertRomanToNumber(romanDigit.toString());
    }

    private static int convertRomanToNumber(String romanString) throws WrongRomanInputError {
        if (romanString.matches(romanNumberValidator)) {

            int romanLength = romanString.length();
            int val = 0;
            int previousNum = 0;
            int decimalNum = 0;
            for (int i = romanLength - 1; i >= 0; i--) {
                char romanChar = romanString.charAt(i);
                romanChar = Character.toUpperCase(romanChar);
                switch (romanChar) {
                    case 'I':
                        previousNum = val;
                        val = 1;
                        break;
                    case 'V':
                        previousNum = val;
                        val = 5;
                        break;
                    case 'X':
                        previousNum = val;
                        val = 10;
                        break;
                    case 'L':
                        previousNum = val;
                        val = 50;
                        break;
                    case 'C':
                        previousNum = val;
                        val = 100;
                        break;
                    case 'D':
                        previousNum = val;
                        val = 500;
                        break;
                    case 'M':
                        previousNum = val;
                        val = 1000;
                        break;
                }
                if (val < previousNum) {
                    decimalNum = decimalNum - val;
                } else
                    decimalNum = decimalNum + val;
            }

            return decimalNum;
        } else {
            throw new WrongRomanInputError();
        }
    }
}
