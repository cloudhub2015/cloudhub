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
 * [08/17/2015] 0.02 - David Ramirez - Code documentation
 * [09/07/2015] 0.03 - Jacquelyn Amaya - Return session attribute for user's first name
 */
public class DisplayController extends Controller {

    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            taskList = service.getTaskList();
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("Server controller error: " + e.getMessage());
        }
        
        json.put("firstName", sessionScope("firstName"));
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
