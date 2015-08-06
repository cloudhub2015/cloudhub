package taskmanagement.controller.user;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import taskmanagement.dto.UserDto;
import taskmanagement.service.UserService;

/**
 * Controller to register a user
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class RegisterController extends Controller {
    private UserService service = new UserService();
    @Override
    public Navigation run() throws Exception {
        if(super.isPost()){
        Map<String,Object> input = new RequestMap(this.request);
        UserDto userDto = new UserDto();
        BeanUtil.copy(input, userDto);
        service.addUser(userDto);
        //return redirect(this.basePath);
        }
        return forward("signup.jsp");
    }
}