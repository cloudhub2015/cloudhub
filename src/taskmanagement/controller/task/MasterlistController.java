package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;
/**
 * Initial Controller
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [08/17/2015] 0.01 - David Ramirez - Initial codes
 */
public class MasterlistController extends Controller {

    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {

        return forward("masterlist.jsp");
    }
}
