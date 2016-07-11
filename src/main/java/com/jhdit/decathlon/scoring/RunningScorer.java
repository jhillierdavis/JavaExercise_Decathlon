package com.jhdit.decathlon.scoring;

/**
 *
 */

class RunningScorer extends DefaultScorer {

    RunningScorer(double multiplier, double offset, double power)    {
        super(multiplier, offset, power);
    }

    @Override
    public double  calculateScore(double value)   {
        return this.multiplier * Math.pow(this.offset - value, this.power);
    }
}
