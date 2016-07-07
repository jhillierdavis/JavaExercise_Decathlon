/**
 *
 */
class RunningScorer extends Scorer {

    RunningScorer(double multiplier, double offset, double power)    {
        super(multiplier, offset, power);
    }

    @Override
    double  calculateScore(double value)   {
        return this.multiplier * Math.pow(this.offset - value, this.power);
    }
}
