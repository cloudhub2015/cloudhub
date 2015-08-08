package taskmanagement.controller.user;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import taskmanagement.model.Task;
import taskmanagement.model.User;
import taskmanagement.service.TaskService;
import taskmanagement.service.UserService;

public class IndexController extends Controller {

    UserService service = new UserService();
    @Override
    public Navigation run() throws Exception {
        String masterListPage = "../task/masterlist.jsp";
        List<User> userList = service.getUsersList();
 
        return forward("signup.jsp");
    }
}
