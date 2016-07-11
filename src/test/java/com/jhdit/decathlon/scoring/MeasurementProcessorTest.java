package com.jhdit.decathlon.scoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for MeasurementProcessor.
 */

@RunWith(JUnitParamsRunner.class)
public class MeasurementProcessorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    @Parameters({
            // event, value , expected
            "100m, 10.64, 942" ,
            "100m, 10.2, 1047" ,
            "100m, 9.58, 1202",
            "Javelin, 64.3, 803"
    })
    public void getScore(String event, float value, int expected)  {
        // Given:
        MeasurementProcessor processor = new MeasurementProcessor();

        // When:
        int score = processor.getScore(event,  value);

        // Then:
        assertThat(score, is(expected));
    }

    /**
     * Scores from https://en.wikipedia.org/wiki/Decathlon
     */

    @Test
    @Parameters({
            // event, value , expected
            "100m, 10.2, 1047" , // Usain Bolt
            "110m, 12.80, 1135", // Aries Merritt
            "400m, 43.18, 1156", // Michael Johnson
            "1500m, 206.00, 1218" , // Hicham El Guerrouj
            "Discus, 74.08, 1383" , // Jürgen Schult
            "Javelin, 98.48, 1331" , // Jan Železný
            "Shot, 23.12, 1295" , // Randy Barnes
            "Long, 895, 1312" , // Mike Powell
            "High, 245, 1244" , // Mike Powell
            "Pole, 616, 1284"// Renaud Lavillenie

    })
    public void getWordRecordScore(String event, double value, int expected)    {
        // Given:
        MeasurementProcessor processor = new MeasurementProcessor();

        // When:
        int score = processor.getScore(event,  value);

        // Then:
        assertThat(score, is(expected));
    }
}
