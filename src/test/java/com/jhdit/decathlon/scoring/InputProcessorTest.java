package com.jhdit.decathlon.scoring;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Unit tests for InputProcessor
 */

public class InputProcessorTest {
    private static List<String> input;

    @BeforeClass
    public static void inputSetUp() {
        input = new ArrayList<>();
        input.add("Carter 100m 10.64");
        input.add("Bush 100m 10.20");
        input.add("Reagan 100m 10.3");
        input.add("#");
        input.add("Reagan Javelin 60.4");
        input.add("Carter Javelin 64.3");
        input.add("REAGAN Long 690");
        input.add("Bush 400m 43.2");
        input.add("#");
        input.add("##");
    }

    @Test
    public void testProcessSingleEvent()  {
        // Given:
        InputProcessor processor = new InputProcessor();

        // When:
        List<String> output = processor.process(input);

        // Then:
        assertThat( output.size(), is(7) );

        // And:
        assertThat( output.get(0), is("BUSH                 1047") );
        assertThat( output.get(1), is("REAGAN               1023") );
        assertThat( output.get(2), is("CARTER                942") );
        assertThat( output.get(3), is(""));
        assertThat( output.get(4), is("REAGAN               1534") );
        assertThat( output.get(5), is("BUSH                 1155") );
        assertThat( output.get(6), is("CARTER                803") );
    }
}
