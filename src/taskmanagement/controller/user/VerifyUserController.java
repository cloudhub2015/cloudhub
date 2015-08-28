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
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/17/2015] 0.02 - David Ramirez - Code documentation
 * [08/27/2015] 0.03 - Jacquelyn Amaya - Implemented the function for logging in using JSON
 */
public class VerifyUserController extends Controller {
    /**
     * The service class which holds the validateUser method
     */
    private UserService service = new UserService();
    @Override
    
    public Navigation run() throws Exception {
        UserDto dto = new UserDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));

            dto.setUsername(json.getString("username"));
            dto.setPassword(json.getString("password"));
            if (dto.getUsername() == null || dto.getPassword() == null) {
                dto.getErrorList().add("Invalid username or password.");
            } else {
                dto = this.service.validateUser(dto);
            }
        } catch (Exception e) {
            dto.getErrorList().add("Server controller error: " + e.getMessage());
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
