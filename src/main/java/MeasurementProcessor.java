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
        scorerMap.put("Discus", new ThrowingScorer(12.91, 4, 1.1));
        scorerMap.put("Javelin", new ThrowingScorer(10.14, 7, 1.08));
        scorerMap.put("Shot", new ThrowingScorer(51.39, 1.5, 1.05));
        scorerMap.put("Long", new JumpingScorer(0.14354, 220, 1.4));
        scorerMap.put("High", new JumpingScorer(0.8465, 75, 1.42));
        scorerMap.put("Pole", new JumpingScorer(0.2797, 100, 1.35));
    }

    int getScore(String event, double value) {
        try {
            double result = (scorerMap.get(event)).calculateScore(value);
            return new Double(Math.floor(result)).intValue();
        } catch (NullPointerException npe)  {
            throw new IllegalArgumentException("Unknown event: " + event);
        }
    }

    /*
    int getScore(String event, float value) {
        double result;

        switch(event)   {

            default:
                throw new IllegalArgumentException("Unknown event: " + event);

            // Running: 100m, 110m hurdles, 400m and 1,500m
            case "100m":
                Scorer scorer = new RunningScorer(25.4347, 18, 1.81);
                result = scorer.calculateScore(value);
                break;

            case "400m":
                scorer = new RunningScorer(1.53775, 82, 1.81);
                result = scorer.calculateScore(value);
                break;

            // Throwing: Discus, javelin and shot put.
            case "Javelin":
                // result = 10.14 * Math.pow(value - 7, 1.08);
                scorer = new ThrowingScorer(10.14, 7, 1.08);
                result = scorer.calculateScore(value);
                break;

            // Jumping: Long jump, high jump and pole vault
        }

        return new Double( Math.floor(result) ).intValue();
    }*/
}
