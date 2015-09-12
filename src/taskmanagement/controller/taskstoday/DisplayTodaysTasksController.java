package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;
/**
 * Controller to add a task to Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/08/2015] 0.02 - Jacquelyn Amaya - Implemented display tasks for today using JSON
 * [09/07/2015] 0.03 - Jacquelyn Amaya - Return session attribute for user's first name
 */
public class DisplayTodaysTasksController extends Controller {
    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            taskList = service.getTodaysTaskList(Long.parseLong(sessionScope("userId").toString()));
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("DISPLAY TODAYS - Server controller error: " + e.getMessage());
        }
        
        json.put("firstName", sessionScope("firstName"));
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }
}
