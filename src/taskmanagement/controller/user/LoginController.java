package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.UserDto;
import taskmanagement.service.UserService;

/**
 * Controller to verify the user
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [08/28/2015] 0.01 - Jacquelyn Amaya - Get the details of the user after logging in
 */
public class LoginController extends Controller {
    /**
     * The service class which holds the validateUser method
     */
    private UserService service = new UserService();
    
    @Override
    protected Navigation run() throws Exception {
        UserDto dto = new UserDto();
        JSONObject json = null;
        
        try {
            json = new JSONObject((String)this.requestScope("data"));
            dto.setUsername(json.getString("username"));
            dto = this.service.getUser(dto.getUsername());
            dto = this.service.updateUser(dto);
        } catch (Exception e) {
            //dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }
        sessionScope("firstName", dto.getFirstName());
        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
