package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import taskmanagement.service.UserService;
/**
 * IndexController for the user to login
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 *
 */
public class IndexController extends Controller {

    UserService service = new UserService();
    @Override
    public Navigation run() throws Exception {
        return forward("signup.jsp");
    }
}
