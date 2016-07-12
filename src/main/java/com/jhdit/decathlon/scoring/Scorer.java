package com.jhdit.decathlon.scoring;

/**
 * Interface for implementing classes encapsulating the scoring algorithm for a specific type of Decathlon event (e.g. running, throwing or jumping).
 */

interface Scorer {
    double calculateScore(double value);
}
