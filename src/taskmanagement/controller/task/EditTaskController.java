package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;

/**
 * Controller to edit task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/27/2015] 0.02 - Jacquelyn Amaya - Implemented the function for updating the task using JSON
 * [09/13/2015] 0.03 - Jacquelyn Amaya - Added conditional statement for "GET" and "PUT" method to display and to edit task, respectively
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
                long taskId = asLong("id");
                Task task = service.getTask(taskId);
                if(null != task) {
                    json = new JSONObject(meta.modelToJson(task));
                }
            }
        } else if(isPost()) {
            try {
                json = new JSONObject((String)this.request.getReader().readLine());
                dto.setName(json.getString("name"));
                dto.setPhase(json.getString("phase"));
                dto.setEstHours(json.getDouble("estHours"));
                dto.setStartDate(json.getString("startDate"));
                dto.setDueDate(json.getString("dueDate"));
                dto.setId(json.getLong("id"));
                dto = service.updateTask(dto);
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
