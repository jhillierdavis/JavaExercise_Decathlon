/**
 *
 */

class ThrowingScorer extends Scorer {

    ThrowingScorer(double multiplier, double offset, double power)    {
        super(multiplier, offset, power);
    }

    @Override
    double  calculateScore(double value)   {
        return this.multiplier * Math.pow(value - this.offset, this.power);
    }
}
