package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class UpdateTaskController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("update_task.jsp");
    }
}
