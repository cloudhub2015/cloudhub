package taskmanagement.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        removeSessionScope("firstName");
        removeSessionScope("lastName");
        removeSessionScope("username");
        removeSessionScope("password");
        return forward("index.jsp");
    }
}
