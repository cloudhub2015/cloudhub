package sample.service;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import taskmanagement.service.UserService;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserInformationTest extends AppEngineTestCase {

    private UserService service = new UserService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }
}
