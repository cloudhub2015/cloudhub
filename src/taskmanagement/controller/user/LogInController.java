package taskmanagement.controller.user;

import java.util.List;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import taskmanagement.model.User;
import taskmanagement.service.UserService;

/**
 * Controller for the user to login
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/17/2015] 0.02 - David Ramirez - Code documentation
 */
public class LogInController extends Controller {
    /**
     * The LogInController class is used for the Log In validations
     */
    private UserService service = new UserService();
    @Override
    
    public Navigation run() throws Exception {
        if(super.isPost()){
            List<User> userList = service.getUsersList();
            requestScope("userList", userList);
        }
        return forward("/");
    }

}
