package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.UserDto;
import taskmanagement.service.UserService;

/**
 * Controller to register a user
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/07/2015] 0.02 - Jacquelyn Amaya - User Registration using JSON
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
            /*dto.setTelephone(json.getString("telephone"));
            dto.setEmail(json.getString("email"));*/
           
            if ((dto.getFirstName() == null) || (dto.getLastName() == null) || (dto.getFirstName() == null) || (dto.getUsername() == null) || dto.getUsername().isEmpty() || (dto.getPassword() == null)) {
                dto.getErrorList().add("Some fields are blank. Please supply those missing fields.");
            } else {
                dto = this.service.addUser(dto);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return forward("../index.jsp");
    }
}
