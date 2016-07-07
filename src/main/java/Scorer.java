/**
 * Abstract class for encapsulating the scoring algorithm for a specific type of Decathlon event (e.g. running, throwing or jumping).
 */

abstract class Scorer {

    double multiplier;
    double offset;
    double power;

    Scorer(double multiplier, double offset, double power)    {
        this.multiplier = multiplier;
        this.offset = offset;
        this.power = power;
    }

    abstract double calculateScore(double value);
}
