package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to edit task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/27/2015] 0.02 - Jacquelyn Amaya - Implemented the function for updating the task using JSON
 */
public class EditTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.request.getReader().readLine());
            
            dto.setId(json.getLong("id"));
            dto.setName(json.getString("name"));
            dto.setPhase(json.getString("phase"));
            dto.setEstHours(json.getDouble("estHours"));
            dto.setStartDate(json.getString("startDate"));
            dto.setDueDate(json.getString("dueDate"));
            dto.setSpentHours(json.getDouble("spentHours"));
            if ((dto.getName() == null) || (dto.getPhase() == null) || (dto.getEstHours() == 0.0) || (dto.getStartDate() == null) || (dto.getDueDate() == null) || (dto.getSpentHours() == 0.0)) {
                dto.getErrorList().add("Some fields are blank. Please supply them.");
            } else {
                dto = this.service.updateTask(dto);
            }
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
