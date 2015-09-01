package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.UserDto;
import taskmanagement.service.UserService;

/**
 * IndexController for the user to login
 * @author Vine Deiparine
 * @version 0.02
 * Version History
 * [09/01/2015] 0.01 - Vine Deiparine - Initial codes
 *
 */

public class DisplayUsernameController extends Controller {
    
    private UserService service = new UserService();

    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        
        UserDto dto = new UserDto();
        JSONObject json = null;
        try {
            json = new JSONObject((String)this.requestScope("data"));
            
            dto.setId(json.getLong("id"));
            /*dto.setTaskName(json.getString("name"));
            dto.setName(json.getString("name"));
            int phase = json.getInt("phase"); 
            switch (phase) {
                case 1:
                    dto.setPhase("Testing");
                    break;
                case 2:
                    dto.setPhase("Coding");
                    break;
                case 3:
                    dto.setPhase("Design");
                    break;
                default:
                    dto.setPhase("Testing");
            }
            dto.setEstHours(json.getDouble("estHours"));
            dto.setStartDate(json.getString("startDate"));
            dto.setDueDate(json.getString("dueDate"));*/
            //if () {
                //dto.getErrorList().add("Some fields are blank. Please supply them.");
            //} else {
                dto = this.service.getUser(json.getString("username"));
            //}
            
          //  dto = this.service.editTask(dto);
        } catch (Exception e) {
         //   dto.getErrorList().add("Server controller error: " + e.getMessage());
            if (json == null) {
                json = new JSONObject();
            }
        }
        json.put("name", dto.getUsername());
        json.put("errorList", dto.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
