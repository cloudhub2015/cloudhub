package taskmanagement.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.UserDto;
import util.Utils;
import taskmanagement.meta.UserMeta;
import taskmanagement.model.User;
import taskmanagement.service.UserService;
import validator.JSONValidators;
/**
 * Controller to put the session attributes for the user
 * @author Jacquelyn Amaya
 * @version 0.02
 * Version History
 * [09/07/2015] 0.01 - Jacquelyn Amaya - Return session attributes for the user's information using JSON
 * [09/13/2015] 0.02 - Jacquelyn Amaya - Retrieve and update user's information
 * [09/29/2015] 0.03 - Vine Deiparine - Modified get and post implementation. Added validations.
 
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
                    json.put("errorList", dto.getErrorList());
                    response.getWriter().write(json.toString());
                }
            } else {
                try {                    
                    json = new JSONObject((String)this.request.getReader().readLine());
        
                    JSONValidators validator = new JSONValidators(json);
                
                    //validator.add("userId", validator.required(), validator.longType());
                    validator.add("username", validator.required());
                    validator.add("firstName", validator.required());
                    validator.add("lastName", validator.required());
                    validator.add("password", validator.required(), validator.minlength(6));
                    
                    if (validator.validate()) {
                        dto.setId(Long.parseLong(sessionScope("userId").toString()));
                        dto.setUsername(json.getString("username"));
                        dto.setFirstName(json.getString("firstName"));
                        dto.setLastName(json.getString("lastName"));
                        dto.setPassword(json.getString("password"));
                        dto = service.updateUser(dto);
                        System.out.println("VALIDATE");
                    } else { 
                        List<String> errorList = new ArrayList<String>(); 
                        validator.addErrorsTo(errorList);
                        
                        System.out.println("NOT VALIDATE");
                        for(int i=0; i<validator.getErrors().size(); i++) {
                            System.out.println(""+ validator.getErrors().get(i));
                            dto.getErrorList().add(""+ validator.getErrors().get(i));
                        }

                        JSONObject r = new JSONObject(); 
                        JSONArray errors = Utils.listToJson(errorList); 
                        r.put("errors", errors); 
                         
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Input Validation Error"); 
                        response.setContentType("application/json"); 
                        json.put("errorList", dto.getErrorList());
                        response.getWriter().write(r.toString()); 
                    }
                } catch (Exception e) {
                    /**dto.getErrorList().add("Server controller error: " + e.getMessage());
                    if (json == null) {
                        json = new JSONObject();                    
                    }**/
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Request body must be JSON");
    
                }
            }
        } else {
            dto.getErrorList().add("No user to refer to");
            if (json == null) {
                json = new JSONObject();                    
            }
            json.put("errorList", dto.getErrorList());
            response.getWriter().write(json.toString());
        }        
        return null;
    }

}
