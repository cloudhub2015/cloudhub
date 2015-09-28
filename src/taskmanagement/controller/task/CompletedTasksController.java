package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

/**
 * Controller to display the list of completed tasks
 * @author David Ramirez
 * @version 0.02
 * Version History
 * [08/27/2015] 0.01 - Jacquelyn Amaya - Display completed tasks
 */
public class CompletedTasksController extends Controller {

    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            System.out.println("Tasks List before");
            taskList = service.getFinishedTasksList();
            System.out.println("Tasks List");
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("Server controller error: " + e.getMessage());
        }
        
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
