package taskmanagement.controller.task;

/**
 * Controller to display a task
 * @author David Ramirez
 * @version 0.02
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/17/2015] 0.02 - David Ramirez   - JSON manipulation
 */

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;
/**
 * Controller to display the list of tasks
 * @author David Ramirez
 * @version 0.02
 * Version History
 * [08/16/2015] 0.01 - David Ramirez - Display task working
 */
public class MasterlistController extends Controller {

    //TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        return forward("masterlist.jsp");
    }
}
