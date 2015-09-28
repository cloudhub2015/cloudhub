package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
/**
 * Controller to redirect to index page
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [09/28/2015] 0.01 - Jacquelyn Amaya - Removes session attributes
 */
public class LogoutController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        removeSessionScope("userId");
        removeSessionScope("firstName");
        return redirect("/");
    }
}
