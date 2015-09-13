package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to add a task to Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/08/2015] 0.02 - Jacquelyn Amaya - Implemented deleting task for today using JSON
 * [09/13/2015] 0.03 - Jacquelyn Amaya - Used deleteTaskToday method of the TaskService class
 */
public class DeleteTaskTodayController extends Controller {

    /**
     * The TaskService to use.
     * Holds the method for deleting today's task
     */
    private TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.request.getReader().readLine());
            dto.setId(json.getLong("id"));
            dto = this.service.deleteTaskToday(dto);
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }

        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
