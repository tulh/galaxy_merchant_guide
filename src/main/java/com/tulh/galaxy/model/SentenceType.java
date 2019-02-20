package com.tulh.galaxy.model;

/**
 * Define all sentence type and regex pattern to match user input
 */
public enum SentenceType {
    ASSIGN_ROMAN("^(\\S+)\\s+is\\s+([I|V|X|L|C|D|M])$"),
    CREDIT_CONVERT("^([a-zA-Z0-9_ ]*)\\s+(Silver|Gold|Iron)\\s+is\\s+(\\d+)\\s+Credits$"),
    HOW_MUCH("^how\\s+much\\s+is\\s+([a-zA-Z0-9_ ]*)\\s*\\?$"),
    HOW_MANY_CREDITS("^how\\s+many\\s+Credits\\s+is\\s+([a-zA-Z0-9_ ]*)(Silver|Gold|Iron)\\s*\\?$"),
    COMPARE_MATERIAL("^Does\\s+([a-zA-Z0-9_ ]*)\\s+(Silver|Gold|Iron)\\s+has\\s+more\\s+Credits\\s+than\\s+([a-zA-Z0-9_ ]*)\\s+(Silver|Gold|Iron)\\s*\\?$"),
    COMPARE_GALAXY_NUMBER("^Is\\s+([a-zA-Z0-9_ ]*)\\s+larger\\s+than\\s+([a-zA-Z0-9_ ]*)\\s*\\?$");

    private String pattern;

    public String getPattern() {
        return this.pattern;
    }

    SentenceType(String pattern) {
        this.pattern = pattern;
    }

}
