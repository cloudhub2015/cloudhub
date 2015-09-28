package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.UserDto;
import taskmanagement.meta.UserMeta;
import taskmanagement.model.User;
import taskmanagement.service.UserService;
/**
 * Controller to put the session attributes for the user
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [09/07/2015] 0.01 - Jacquelyn Amaya - Return session attributes for the user's information using JSON
 * [09/13/2015] 0.02 - Jacquelyn Amaya - Retrieve and update user's information
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
        
        UserDto dto = new UserDto();
        JSONObject json = null;
        
        response.setContentType("application/json");
        if(null != sessionScope("userId")) {
            if(isGet()) {
                if(null != sessionScope("userId")) {
                    long id = Long.parseLong(sessionScope("userId").toString());
                    User user = service.getUser(id);
                    json = new JSONObject(meta.modelToJson(user));
                }
            } else {
                try {
                    
                    json = new JSONObject((String)this.request.getReader().readLine());
                    dto.setId(Long.parseLong(sessionScope("userId").toString()));
                    dto.setUsername(json.getString("username"));
                    dto.setFirstName(json.getString("firstName"));
                    dto.setLastName(json.getString("lastName"));
                    dto.setPassword(json.getString("password"));
                    dto = service.updateUser(dto);
                } catch (Exception e) {
                    dto.getErrorList().add("Server controller error: " + e.getMessage());
                    if (json == null) {
                        json = new JSONObject();
                    }
                }
            }
        } else {
            dto.getErrorList().add("No user to refer to");
        }
        json.put("errorList", dto.getErrorList());
        response.getWriter().write(json.toString());
        return null;
    }

}
