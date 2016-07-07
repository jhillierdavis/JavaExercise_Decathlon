import junitparams.Parameters;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */

public class EventProcessorTest {

    @Test
    public void testProcessSingleEvent()  {
        // Given:
        EventProcessor processor = new EventProcessor();
        processor.addEntry("Carter", "100m", 10.64);
        processor.addEntry("Bush", "100m", 10.20);
        processor.addEntry("Reagan", "100m", 10.3);

        // When:
        List resultsList = processor.getResults();

        // Then:
        assertThat( resultsList.size(), is(3) );
        assertThat( resultsList.get(0), is("BUSH                 1047") );
        assertThat( resultsList.get(1), is("REAGAN               1023") );
        assertThat( resultsList.get(2), is("CARTER                942") );
    }

    @Test
    public void testProcessMultipleEvents()  {
        // Given:
        EventProcessor processor = new EventProcessor();
        processor.addEntry("Reagan", "Javelin", 60.4);
        processor.addEntry("Carter", "Javelin", 64.3);
        processor.addEntry("REAGAN", "Long", 690);
        processor.addEntry("Bush", "400m", 43.2);

        // When:
        List resultsList = processor.getResults();

        // Then:
        assertThat( resultsList.size(), is(3) );
        assertThat( resultsList.get(0), is("REAGAN               1534") );
        assertThat( resultsList.get(1), is("BUSH                 1155") );
        assertThat( resultsList.get(2), is("CARTER                803") );
    }

}
