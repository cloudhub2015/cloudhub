package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

/**
 * Initial Controller
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 - Jacquelyn Amaya - Implemented retrieving searched task(s) using JSON
 */
public class SearchTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method searchTasks()
     */
    private TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        TaskClientDto taskList = new TaskClientDto();
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
        response.getWriter().write(json.toString());
        return null;
        //return forward("search_task.jsp");
    }
}
