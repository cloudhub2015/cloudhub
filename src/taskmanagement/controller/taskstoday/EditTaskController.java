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
 */
public class EditTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method updateTask()
     */
    private TaskService service = new TaskService();
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        if(isGet()) {
            if(null != requestScope("id")) {
                long id = asLong("id");
                //Task task = this.service.selectTask(id);
                if(null != dto) {
                    //json = new JSONObject(TaskMeta.get().modelToJson(task));
                }
            }
        }
        else {
            try {
                json = new JSONObject((String)this.requestScope("data"));
                
                dto.setId(json.getLong("id"));
                dto.setName(json.getString("name"));
                dto.setPhase(json.getString("phase"));
                dto.setSpentHours(json.getDouble("spentHours"));
                if(1 == json.getInt("status")) {
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
                }
            }
        }
        
        json.put("errorList", dto.getErrorList());
        response.getWriter().write(json.toString());
        return null;
    }

}
