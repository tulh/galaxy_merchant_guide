package com.tulh.galaxy.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Store all exchange rate and roman assignment from user input
 */
public class ConversionInputHolder {

    private static final ConversionInputHolder instance = new ConversionInputHolder();

    private ConversionInputHolder(){}

    public static ConversionInputHolder getInstance(){
        return instance;
    }

    public Map<String, String> galaxyNumberRomanMap = new HashMap<>();
    public Map<String, Double> materialConversionRateMap = new HashMap<>();
}
