package com.jhdit.decathlon.scoring;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

/**
 * Process a set of competitor events to generate a set of scores for all competitors.
 */

class EventProcessor {
    private MeasurementProcessor measurementProcessor = new MeasurementProcessor();
    private Map<String, Double> competitorToScopeMap = new HashMap<>();
    private static final Double ZERO_AS_DOUBLE  = 0d;


    void addEntry(String competitorName, String eventName, double measurement)  {
        double score = measurementProcessor.getScore(eventName, measurement);
        String key = competitorName.trim().toUpperCase();

        Optional<Double> existingScoreOptional = Optional.ofNullable( this.competitorToScopeMap.get(key) );
        this.competitorToScopeMap.put(key, score + existingScoreOptional.orElse( ZERO_AS_DOUBLE ) );
    }

    List<String> getResults()   {
        List<String> resultsList = this.competitorToScopeMap.entrySet().stream()
                .sorted( Comparator.comparing(Map.Entry::getValue, reverseOrder()) )
                // .map( Map.Entry::getKey )
                .map( e -> this.format(e.getKey(), e.getValue() ) )
                .collect(Collectors.toList());
        return resultsList;
    }

    private String format(String key, Double value) {
        return String.format("%1$-18s %2$6d", key, value.intValue() );
    }
}
