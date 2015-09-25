package taskmanagement.controller.taskstoday;

import java.util.ArrayList;

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
 * [09/15/2015] 0.03 - Jacquelyn Amaya - Added validation for updating spent time
 * [09/25/2015] 0.04 - Jacquelyn Amaya - Changed error messages
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
    
    private final double MAX_TASK_HOURS_PER_DAY = 8;
    
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
                if(null == dto.getErrorList()) {
                    dto.setErrorList(new ArrayList<String>());
                } 
                json = new JSONObject((String)this.request.getReader().readLine());
                
                dto.setId(json.getLong("id"));
                
                if (json.getDouble("spentHours") == 0.0) {
                    dto.getErrorList().add("Spent Time cannot be 0 or empty");
                } else if(json.getDouble("spentHours") < 0.0){
                    dto.getErrorList().add("Spent Time should not be less than 0");
                } else if(json.getDouble("spentHours") > MAX_TASK_HOURS_PER_DAY){
                    dto.getErrorList().add("Spent Time should not exceed 8.0 hrs");
                } else if(json.getDouble("spentHours") <= 8.0){
                    dto.setSpentHours(json.getDouble("spentHours"));
                }
                
                if(dto.getSpentHours() <= MAX_TASK_HOURS_PER_DAY) {
                    dto = this.service.updateTaskToday(dto);
                } else {
                    dto.getErrorList().add("Spent Hours should not exceed 8.0 hrs");
                }
                    
                
            } catch (Exception e) {
                dto.getErrorList().add("Spent Time contains non-numeric values");
                if (json == null) {
                    json = new JSONObject();
                    
                }
            }
        }
        json.put("errorList", dto.getErrorList());
        response.getWriter().write(json.toString());
        return null;
    }

}
