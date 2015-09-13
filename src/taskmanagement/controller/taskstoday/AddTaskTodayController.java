package taskmanagement.controller.taskstoday;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;
import taskmanagement.service.TaskService;

/**
 * Controller to add a task to Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/08/2015] 0.02 - Jacquelyn Amaya - Implemented adding task for today using JSON
 */
public class AddTaskTodayController extends Controller {
    /**
     * The TaskService to use.
     * Holds the method for adding a task.
     */
    private TaskService service = new TaskService();
    
    /**
     * The TaskMeta to use
     * Holds the method get()
     */
    //private TaskMeta meta = TaskMeta.get();
    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        
        TaskDto dto = new TaskDto();
        JSONObject json = null;
        try {
            /*if(null != requestScope("id")) {
                long taskId = asLong("id");
                Task task = service.getTask(taskId);
                if(null != task) {
                    json = new JSONObject(meta.modelToJson(task));
                    dto.setId(json.getLong("id"));
                    dto.setName(json.getString("name"));
                    dto.setPhase(json.getString("phase"));
                    dto.setEstHours(json.getDouble("estHours"));
                    dto.setStartDate(json.getString("startDate"));
                    dto.setDueDate(json.getString("dueDate"));
                    if(dto.isToday()){
                        dto.getErrorList().add("The task has already been added to Today's Tasks");
                    } else {
                        dto.setToday(true);
                        dto = this.service.updateTask(dto);
                    }            
                }
            }*/
            
            json = new JSONObject((String)this.request.getReader().readLine());
            dto.setId(json.getLong("id"));
            if(dto.isToday()){
                dto.getErrorList().add("The task has already been added to Today's Tasks");
            } else {
                dto = this.service.addTaskToday(dto);
            }
            
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
                json.put("errorList", dto.getErrorList());
            }
        }

        response.getWriter().write(json.toString());
        return null;
    }

}
