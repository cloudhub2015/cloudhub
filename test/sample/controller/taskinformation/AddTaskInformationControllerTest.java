package sample.controller.taskinformation;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;

import sample.controller.task.AddTaskController;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AddTaskInformationControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/taskinformation/AddTaskInformation");
        AddTaskController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/taskinformation/AddTaskInformation.jsp"));
    }
}
