package sample.controller.task;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import taskmanagement.controller.task.SearchTaskController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SearchTaskControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/task/SearchTask");
        SearchTaskController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/task/SearchTask.jsp"));
    }
}
