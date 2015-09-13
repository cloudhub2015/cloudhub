package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to delete task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/07/2015] 0.02 - Jacquelyn Amaya - Implemented the function for deleting the task using JSON
 */
public class DeleteTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method deleteTask()
     */
    private TaskService service = new TaskService();
    
    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        TaskDto dto = new TaskDto();
        
        JSONObject json = null;
        
        try {
            
            json = new JSONObject((String)this.request.getReader().readLine());
            dto.setId(json.getLong("id"));
            
            dto = this.service.deleteTask(dto);
            
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            System.out.println(e.getMessage());
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
