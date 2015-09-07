package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

public class DisplayTodaysTasksController extends Controller {
    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            taskList = service.getTodaysTaskList();
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
