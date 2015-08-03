package sample.controller.taskstoday;

import java.util.Map;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

import sample.dto.TaskDayDto;
import sample.service.TaskDayService;

/**
 * Controller to add to Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class AddTaskTodayController extends Controller {
    /**
     * The TaskDayService to use.
     * Holds the method for adding a task.
     */
    private TaskDayService service = new TaskDayService();
    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        Map<String,Object> input = new RequestMap(this.request);
        TaskDayDto taskDayDto = new TaskDayDto();
        BeanUtil.copy(input, taskDayDto);
        service.addTaskDay(taskDayDto);
        return forward("todays_task.jsp");
    }

}
