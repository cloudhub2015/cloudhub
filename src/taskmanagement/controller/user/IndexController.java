package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import taskmanagement.service.UserService;

public class IndexController extends Controller {

    UserService service = new UserService();
    @Override
    public Navigation run() throws Exception { 
        return forward("signup.jsp");
    }
}
