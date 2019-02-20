package com.tulh.galaxy.processor;

public class SentenceMaker {
    private SentenceProcessor assignRoman;
    private SentenceProcessor creditConvert;
    private SentenceProcessor questionHowMuch;
    private SentenceProcessor questionHowMany;
    private SentenceProcessor compareMoreLess;
    private SentenceProcessor compareLagerSmaller;

    public SentenceMaker() {
        this.assignRoman = new AssignRomanProcessor();
        this.creditConvert = new CreditConvertProcessor();
        this.questionHowMuch = new HowMuchProcessor();
        this.questionHowMany = new HowManyCreditProcessor();
        this.compareMoreLess = new CompareMaterialProcessor();
        this.compareLagerSmaller = new CompareGalaxyNumberProcessor();
    }

    public void processAssignRoman(String sentence) {
        assignRoman.process(sentence);
    }

    public void processCreditConvert(String sentence) {
        creditConvert.process(sentence);
    }

    public void processQuestionHowMuch(String sentence) {
        questionHowMuch.process(sentence);
    }

    public void processQuestionHowMany(String sentence) {
        questionHowMany.process(sentence);
    }

    public void processCompareMoreLess(String sentence) {
        compareMoreLess.process(sentence);
    }

    public void processCompareLagerSmaller(String sentence) {
        compareLagerSmaller.process(sentence);
    }
}
