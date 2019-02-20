package com.tulh.galaxy;

import com.tulh.galaxy.model.Sentence;
import com.tulh.galaxy.model.SentenceType;
import com.tulh.galaxy.processor.SentenceMaker;
import com.tulh.galaxy.util.ConversionInputHolder;

import java.util.Objects;

public class GalaxyMerchantHandler {

    void processing(String input) {
        if (Objects.equals(input, "list")) {
            System.out.println("Galaxy assignment and material conversions:");
            for (String assign : ConversionInputHolder.getInstance().galaxyNumberRomanMap.keySet()) {
                System.out.println(String.format("%s = %s", assign, ConversionInputHolder.getInstance().galaxyNumberRomanMap.get(assign)));
            }
            for (String material : ConversionInputHolder.getInstance().materialConversionRateMap.keySet()) {
                System.out.println(String.format("%s = %s", material, ConversionInputHolder.getInstance().materialConversionRateMap.get(material)));
            }
            return;
        }
        boolean isLegalInput = false;
        for (SentenceType sentenceType : SentenceType.values()) {
            if (input.matches(sentenceType.getPattern())) {
                //processing sentence
                isLegalInput = true;
                processSentence(new Sentence(sentenceType, input));
            }
        }
        if (!isLegalInput && !Objects.equals(input, "")) {
            System.out.println("I have no idea what you are talking about");
        }

    }

    private void processSentence(Sentence sentence) {
        SentenceMaker sentenceMaker = new SentenceMaker();
        switch (sentence.getSentenceType()) {
            case ASSIGN_ROMAN:
                sentenceMaker.processAssignRoman(sentence.getText());
                break;
            case CREDIT_CONVERT:
                sentenceMaker.processCreditConvert(sentence.getText());
                break;
            case HOW_MUCH:
                sentenceMaker.processQuestionHowMuch(sentence.getText());
                break;
            case HOW_MANY_CREDITS:
                sentenceMaker.processQuestionHowMany(sentence.getText());
                break;
            case COMPARE_MATERIAL:
                sentenceMaker.processCompareMoreLess(sentence.getText());
                break;
            case COMPARE_GALAXY_NUMBER:
                sentenceMaker.processCompareLagerSmaller(sentence.getText());
                break;
        }
    }
}
