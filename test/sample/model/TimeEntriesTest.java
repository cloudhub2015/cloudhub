package sample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import taskmanagement.model.TimeEntries;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TimeEntriesTest extends AppEngineTestCase {

    private TimeEntries model = new TimeEntries();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
