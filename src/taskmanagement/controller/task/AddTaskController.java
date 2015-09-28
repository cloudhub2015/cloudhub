package taskmanagement.controller.task;

import java.io.IOException;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;
import taskmanagement.dto.TaskDto;
import taskmanagement.service.TaskService;

/**
 * Controller to add task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/02/2015] 0.02 - David Ramirez - added the addTask function
 * [08/07/2015] 0.03 - Jacquelyn Amaya - Implemented add task function using JSON
 */
public class AddTaskController extends Controller {
    /**
     * The TaskService to use
     * Holds the method addTask()
     */
    private TaskService service = new TaskService();
    
    @Override
    public Navigation run()  {
        TaskDto dto = new TaskDto();
        JSONObject json = null;
       
        try {
            json = new JSONObject(this.request.getReader().readLine());
            String sessionUserId = sessionScope("userId").toString();
            if(null != sessionUserId) {
                long userId = Long.parseLong(sessionUserId);
                dto.setUserId(userId);
                dto.setName(json.getString("name"));
                dto.setPhase(json.getString("phase"));
                dto.setEstHours(json.getDouble("estHours"));
                dto.setPending(true);
                
                if(dto.getName() == null || dto.getName().length() < 4) {
                    dto.getErrorList().add("Task name is too short or empty");
                } else {
                    this.service.addTask(dto);
                }
            } else {
                dto.getErrorList().add("No user to refer to");
            }           
            
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + "Task Already Added");
            if (json == null) {
                json = new JSONObject();
            }
        }
        try {
            json.put("errorList", dto.getErrorList());
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
