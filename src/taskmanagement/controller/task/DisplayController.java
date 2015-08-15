package taskmanagement.controller.task;

import java.io.Console;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

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
        
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return forward("masterlist.jsp");
      //  return null;
        /*List<Task> taskList = service.getTaskList();
        requestScope("taskList", taskList);
        return forward("masterlist.jsp");*/
    }
}
