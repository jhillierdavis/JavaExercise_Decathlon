/**
 *
 */

class JumpingScorer extends Scorer {
    JumpingScorer(double multiplier, double offset, double power)    {
        super(multiplier, offset, power);
    }

    @Override
    double  calculateScore(double value)   {
        return this.multiplier * Math.pow( value - this.offset, this.power);
    }
}
