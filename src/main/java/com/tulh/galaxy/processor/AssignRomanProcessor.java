package com.tulh.galaxy.processor;

import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.util.ConversionInputHolder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AssignRomanProcessor implements SentenceProcessor {
    @Override
    public void process(String sentence) {
        Pattern pattern = Pattern.compile(SentenceType.ASSIGN_ROMAN.getPattern());
        Matcher matcher = pattern.matcher(sentence);
        if (matcher.find()) {
            String galaxyDigit = matcher.group(1);
            String romanDigit = matcher.group(2);
            ConversionInputHolder.getInstance().galaxyNumberRomanMap.put(galaxyDigit, romanDigit);
        }
    }
}
