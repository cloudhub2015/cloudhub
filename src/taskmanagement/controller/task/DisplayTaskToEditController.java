package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class DisplayTaskToEditController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        return forward("edit_task.jsp");
    }

}
