package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskDto;
import taskmanagement.dto.UserDto;
import taskmanagement.meta.TaskMeta;
import taskmanagement.meta.UserMeta;
import taskmanagement.model.Task;
import taskmanagement.model.User;
import taskmanagement.service.TaskService;
import taskmanagement.service.UserService;
/**
 * Controller to put the session attributes for the user
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [09/07/2015] 0.01 - Jacquelyn Amaya - Return session attributes for the user's information using JSON
 */
public class LoggedInUserController extends Controller {

    /**
     * The UserService to use
     * Holds the method updateTask()
     */
    private UserService service = new UserService();
    /**
     * The UserMeta to use
     * Holds the method get()
     */
    private UserMeta meta = UserMeta.get();
    
    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        UserDto dto = new UserDto();
        JSONObject json = null;
        
        response.setContentType("application/json");
        
        if(isGet()) {
            if(null != requestScope("username")) {
                String userId = asString("username");
                UserDto user = service.getUser(userId);
                if(null != user) {
                    json = new JSONObject(meta.modelToJson(user));
                }
            }
        } else if(isPost()) {
            try {
                json = new JSONObject((String)this.request.getReader().readLine());
                dto.setUsername(json.getString("username"));
                dto.setFirstName(json.getString("firstName"));
                dto.setLastName(json.getString("lastName"));
                dto.setPassword(json.getString("password"));
                dto = service.updateUser(dto);
            } catch (Exception e) {
                dto.getErrorList().add("Server controller error: " + e.getMessage());
                if (json == null) {
                    json = new JSONObject();
                    json.put("errorList", dto.getErrorList());
                }
            }
        }
       /* 
        json.put("firstName", sessionScope("firstName"));
        json.put("lastName", sessionScope("lastName"));
        json.put("username", sessionScope("username"));
        json.put("userId", sessionScope("userId"));
        */
        response.getWriter().write(json.toString());
        return null;
    }

}
