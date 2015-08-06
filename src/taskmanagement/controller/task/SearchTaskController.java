package taskmanagement.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class SearchTaskController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("search_task.jsp");
    }
}
