package com.jhdit.decathlon.scoring;

import com.jhdit.decathlon.Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * Process input data.
 */

class InputProcessor {

    private static final String OCTOTHORPE = "#";
    private static final String DOUBLE_OCTOTHORPE = "##";

    List<String> process(List<String> input)    {
        List<String> resultsList = new ArrayList<>();

        EventProcessor processor = new EventProcessor();
        for(String str: input)  {
            str = str.trim();

            if (isTerminator(str))  {
                break;
            }

            if (isNewEvent(str))    {
                List<String> values = processor.getResults();
                if (values.size() > 0) {
                    addResultsIfPresentOrBlankLine(resultsList, values);
                    processor = new EventProcessor();
                }
                continue;
            }

            Entry entry = new Entry(str);
            processor.addEntry(entry.getParticipant(), entry.getEventType(), entry.getMeasurement());
        }

        return resultsList;
    }

    private void addResultsIfPresentOrBlankLine(List<String> resultsList, List<String> values) {
        if (resultsList.size() > 0)  {
            resultsList.add("");
        }
        resultsList.addAll(values);
    }

    private boolean isNewEvent(String str)    {
        return OCTOTHORPE.equals(str);
    }

    private boolean isTerminator(String str)  {
        return DOUBLE_OCTOTHORPE.equals(str);
    }

}
