package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
import taskmanagement.service.TaskService;

public class MasterlistController extends Controller {

    TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {

        return forward("masterlist.jsp");
      //  return null;
        /*List<Task> taskList = service.getTaskList();
        requestScope("taskList", taskList);
        return forward("masterlist.jsp");*/
    }
}
