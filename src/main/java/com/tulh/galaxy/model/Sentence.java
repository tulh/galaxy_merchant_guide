package com.tulh.galaxy.model;

public class Sentence {
    private SentenceType sentenceType;
    private String text;

    public SentenceType getSentenceType() {
        return sentenceType;
    }

    public void setSentenceType(SentenceType sentenceType) {
        this.sentenceType = sentenceType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Sentence(SentenceType sentenceType, String text) {
        this.sentenceType = sentenceType;
        this.text = text;
    }
}
