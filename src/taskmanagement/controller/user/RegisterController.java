package taskmanagement.controller.user;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import taskmanagement.dto.TaskDto;
import taskmanagement.dto.UserDto;
import taskmanagement.service.UserService;

/**
 * Controller to register a user
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/17/2015] 0.02 - David Ramirez - Implemented JSON codes
 */
public class RegisterController extends Controller {
    private UserService service = new UserService();
    @Override
    public Navigation run() throws Exception {
        UserDto dto = new UserDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));

            dto.setFirstName(json.getString("firstname"));
            dto.setLastName(json.getString("lastname"));
            dto.setUsername(json.getString("username"));
            dto.setPassword(json.getString("password"));
            if ((dto.getFirstName() == null) || dto.getLastName() == null || dto.getUsername() == null || dto.getPassword() == null) {
                dto.getErrorList().add("Some fields are blank. Please supply them.");
            } else {
                dto = this.service.addUser(dto);
            }
        } catch (Exception e) {
    //        dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }

        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return forward("signup.jsp");
    }
}
