package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Controller for the user to login
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [08/28/2015] 0.01 - Jacquelyn Amaya - Redirect verified user to masterlist page
 */
public class LogInController extends Controller {
    
    @Override
    public Navigation run() throws Exception {
        return forward("../task/masterlist.jsp");
    }
}
