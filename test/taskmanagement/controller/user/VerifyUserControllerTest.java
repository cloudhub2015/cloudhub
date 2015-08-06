package taskmanagement.controller.user;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class VerifyUserControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/user/VerifyUser");
        VerifyUserController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/user/VerifyUser.jsp"));
    }
}
