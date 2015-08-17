package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to edit today's task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/08/2015] 0.02 - Jacquelyn Amaya - Implemented the function for updating the today's task using JSON
 */
public class UpdateTaskController extends Controller {

    /**
     * The TwitterService to use.
     * Holds the method for retrieving list of tasks.
     */
    TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));
            
            dto.setId(json.getLong("id"));
            dto.setSpentHours(json.getDouble("spentHours"));
            if (dto.getSpentHours() == 0.0) {
                dto.getErrorList().add("Provide a value for Spent Time field.");
            } else if(dto.getSpentHours() <= 0.0){
                dto.getErrorList().add("Spent time should not be less than or equal to 0.0 hrs");
            } else if(dto.getSpentHours() > 8.0){
                dto.getErrorList().add("Spent time should not exceed 8.0 hrs");
            } else {
                dto = this.service.updateTask(dto);
            }
        } catch (Exception e) {
          //  dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }

        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return forward("update_task.jsp");
    }

}
