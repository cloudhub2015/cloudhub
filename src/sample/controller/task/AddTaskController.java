package sample.controller.task;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import sample.dto.TaskDto;
import sample.service.TaskService;

/**
 * Controller to add task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/02/2015] 0.02 - David Ramirez - added the addTask function
 */
public class AddTaskController extends Controller {
    
    private TaskService service = new TaskService();
    @Override
    public Navigation run() throws Exception {
        if(super.isPost()){
        Map<String,Object> input = new RequestMap(this.request);
        TaskDto taskDto = new TaskDto();
        BeanUtil.copy(input, taskDto);
        service.addTask(taskDto);
        }
        //return redirect(this.basePath);
        return forward("create_task.jsp");
    }
}
