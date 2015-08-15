package taskmanagement.controller.task;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DisplayControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/task/Display");
        DisplayController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/task/Display.jsp"));
    }
}
