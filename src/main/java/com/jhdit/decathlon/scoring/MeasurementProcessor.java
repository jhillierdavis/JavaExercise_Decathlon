package com.jhdit.decathlon.scoring;

import java.util.HashMap;
import java.util.Map;

/**
 * Decathlon scorer for an individual event (e.g. 100m) measurement.
 */

class MeasurementProcessor {
    private Map<String, Scorer> scorerMap = new HashMap<>();

    MeasurementProcessor() {
        scorerMap.put("100m", new RunningScorer(25.4347, 18, 1.81));
        scorerMap.put("110m", new RunningScorer(5.74352, 28.5, 1.92));
        scorerMap.put("400m", new RunningScorer(1.53775, 82, 1.81));
        scorerMap.put("1500m", new RunningScorer(0.03768, 480, 1.85));
        scorerMap.put("Discus", new DefaultScorer(12.91, 4, 1.1));
        scorerMap.put("Javelin", new DefaultScorer(10.14, 7, 1.08));
        scorerMap.put("Shot", new DefaultScorer(51.39, 1.5, 1.05));
        scorerMap.put("Long", new DefaultScorer(0.14354, 220, 1.4));
        scorerMap.put("High", new DefaultScorer(0.8465, 75, 1.42));
        scorerMap.put("Pole", new DefaultScorer(0.2797, 100, 1.35));
    }

    int getScore(String event, double value) {
        try {
            double result = (scorerMap.get(event)).calculateScore(value);
            return new Double(Math.floor(result)).intValue();
        } catch (NullPointerException npe)  {
            throw new IllegalArgumentException("Unknown event: " + event);
        }
    }
}
