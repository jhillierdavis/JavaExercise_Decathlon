package com.jhdit.decathlon.scoring;

/**
 * Responsible for decathlon scoring , by default using scoring for Jumping & Throwing (as the same!).
 */

class DefaultScorer implements Scorer {
    double multiplier;
    double offset;
    double power;

    DefaultScorer(double multiplier, double offset, double power)    {
        this.multiplier = multiplier;
        this.offset = offset;
        this.power = power;
    }

    @Override
    public double calculateScore(double value)   {
        return this.multiplier * Math.pow(value - this.offset, this.power);
    }
}
