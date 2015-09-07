package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

public class LoggedInUserController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        JSONObject json = null;
        json = new JSONObject();
        json.put("firstName", sessionScope("firstName"));
        json.put("lastName", sessionScope("lastName"));
        json.put("username", sessionScope("username"));
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
    }

}
