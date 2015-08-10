package taskmanagement.controller.task;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import taskmanagement.model.Task;
import taskmanagement.service.TaskService;

public class SearchTaskController extends Controller {
    TaskService service = new TaskService();
    String a = "haha";
    
    @Override
    public Navigation run() throws Exception {
        List<Task> taskList = service.getTaskList();
        requestScope("taskList", taskList);
        return forward("search_task.jsp");
    }
}
