package com.jhdit.decathlon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Data record for a decathlon event type entry for a specific participant.
 */

public class Entry {
    private String participant;
    private String eventType;
    private double measurement;

    private static final Pattern pattern = Pattern.compile("(\\w+)\\s+(\\w+)\\s+([\\d\\.]+)");

    public Entry(String record) {
        if (null == record) {
            throw new IllegalArgumentException("Null input string");
        }

        Matcher m = pattern.matcher(record.trim());
        if (!m.find() && m.groupCount() == 3) {
            throw new IllegalArgumentException("Failed to parse input string: " + record);
        }

        this.participant = m.group(1).toUpperCase();
        this.eventType = m.group(2);
        this.measurement = Double.parseDouble(m.group(3));
    }

    public String getEventType() {
        return eventType;
    }

    public double getMeasurement() {
        return measurement;
    }

    public String getParticipant() {
        return participant;
    }

}
