package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
/**
 * Controller to add a task to Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class SettingsController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("settings.jsp");
    }
}
