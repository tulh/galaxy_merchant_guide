package com.tulh.galaxy;

import com.tulh.galaxy.processor.AssignRomanProcessor;
import com.tulh.galaxy.util.ConversionInputHolder;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestAssignRomanProcessor extends TestCase {
    @Before
    public void setup() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testProcessAssignRoman() {
        String sentence = "glob is I";
        AssignRomanProcessor assignRomanProcessor = new AssignRomanProcessor();
        assignRomanProcessor.process(sentence);
        assertEquals("I", ConversionInputHolder.getInstance().galaxyNumberRomanMap.get("glob"));
    }
}
