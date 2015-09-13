package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;
/**
 * Controller to edit today's task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [09/05/2015] 0.01 - Jacquelyn Amaya - Implemented the function to display the details of the task to edit
 * [09/13/2015] 0.02 - Jacquelyn Amaya - Added conditional statement for "GET" and "PUT" method to display and to edit task, respectively
 */
public class EditTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    /**
     * The TaskMeta to use
     * Holds the method get()
     */
    private TaskMeta meta = TaskMeta.get();
    
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        if(isGet()) {
            if(null != requestScope("id")) {
                long id = asLong("id");
                Task task = service.getTask(id);
                if(null != dto) {
                    json = new JSONObject(meta.modelToJson(task));
                }
            }
        }
        else if(isPost()) {
            try {
                json = new JSONObject((String)this.request.getReader().readLine());
                
                dto.setId(json.getLong("id"));
                dto.setPhase(json.getString("phase"));
                
                if (json.getDouble("spentHours") == 0.0) {
                    dto.getErrorList().add("Provide a value for Spent Time field.");
                } else if(json.getDouble("spentHours") <= 0.0){
                    dto.getErrorList().add("Spent time should not be less than or equal to 0.0 hrs");
                } else if(json.getDouble("spentHours") > 8.0){
                    dto.getErrorList().add("Spent time should not exceed 8.0 hrs");
                } else {
                    dto.setSpentHours(json.getDouble("spentHours"));
                }
                
                if(json.getString("status").equals("Pending")) {
                    dto.setPending(true);
                }
                else {
                    dto.setFinished(true);
                }
                dto = this.service.updateTask(dto);
            } catch (Exception e) {
                dto.getErrorList().add("Server controller error: " + e.getMessage());
                if (json == null) {
                    json = new JSONObject();
                    json.put("errorList", dto.getErrorList());
                }
            }
        }
        
        response.getWriter().write(json.toString());
        return null;
    }

}
