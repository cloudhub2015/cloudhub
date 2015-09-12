package taskmanagement.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
/**
 * Controller to display the index page
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [09/07/2015] 0.01 - Jacquelyn Amaya - Removes session attributes
 */
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
