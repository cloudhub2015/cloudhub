package sample.dao;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import taskmanagement.dao.UserDao;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserDaoTest extends AppEngineTestCase {

    private UserDao dao = new UserDao();

    @Test
    public void test() throws Exception {
        assertThat(dao, is(notNullValue()));
    }
}
