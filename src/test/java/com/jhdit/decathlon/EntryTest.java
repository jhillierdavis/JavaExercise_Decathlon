package com.jhdit.decathlon;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for Entry
 */

@RunWith(JUnitParamsRunner.class)
public class EntryTest {

    @Test
    @Parameters({
            "Carter 100m 10.64",
            "   Carter 100m 10.64",
            "Carter 100m 10.64   ",
            "Carter     100m 10.64",
            "Carter  100m         10.64",
            "Carter\t100m\t10.64",
            "   \tCarter 100m 10.64",
            "Carter 100m 10.64   \t\t",
            "Carter\t100m 10.64",
            "Carter 100m\t10.64",
            "Carter  100m\t10.64"

    })
    public void testEntryParsingWithDifferentFormatting(String record)   {
        // Given:
        Entry entry = new Entry(record);

        // Then:
        assertThat( entry.getParticipant(), is("CARTER") );
        assertThat( entry.getEventType(), is("100m") );
        assertThat( entry.getMeasurement(), is(10.64) );
    }
}
