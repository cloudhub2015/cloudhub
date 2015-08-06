package taskmanagement.controller.user;

import java.util.List;
import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import taskmanagement.dto.TaskDto;
import taskmanagement.dto.UserDto;
import taskmanagement.model.Task;
import taskmanagement.model.User;
import taskmanagement.service.TaskService;
import taskmanagement.service.UserService;

/**
 * Controller for the user to login
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class LogInController extends Controller {
    private UserService service = new UserService();
    @Override
    public Navigation run() throws Exception {
        if(super.isPost()){
     //   Map<String,Object> input = new RequestMap(this.request);
     //   UserDto userDto = new UserDto();
     //   BeanUtil.copy(input, userDto);
     //   service.addUser(userDto);
        //return redirect(this.basePath);
            List<User> userList = service.getUsersList();
            requestScope("userList", userList);
        }
        return forward("/");
    }

}
