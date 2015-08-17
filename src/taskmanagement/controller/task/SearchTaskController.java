package taskmanagement.controller.task;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;


/**
 * Search Task Controller
 * @author Prince Niko Garces
 * @version 0.01
 * Version History
 * [08/17/2015] 0.01 - David Ramirez - Initial codes
 */

public class SearchTaskController extends Controller {
    TaskService service = new TaskService();
    String a = "haha";
    
    @Override
    public Navigation run() throws Exception {
        /*TaskClientDto taskList = new TaskClientDto();
        JSONObject json = null;
        String name = "";
        try {
            json = new JSONObject((String)this.requestScope("data"));
            
            name = json.getString("name");
            if((name == null) || name.isEmpty()){
                taskList.getErrorList().add("Provide task name to be searched.");
            } else {
                taskList = service.searchTasks(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("Server controller error: " + e.getMessage());
        }

        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());*/
        //return null;
        //List<Task> taskList = service.getTaskList();
        return forward("search_task.jsp");
    }
}
