/**
 * 
 */
package sample.controller.taskstoday;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import sample.model.TaskDay;
import sample.service.TaskDayService;

/**
 * Initial Controller
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class IndexController extends Controller {

    /**
     * The TaskDayService to use.
     * Holds the method for retrieving list of today's tasks.
     */
    TaskDayService service = new TaskDayService();

    @Override
    public Navigation run() throws Exception {
        List<TaskDay> tasksTodayList = service.getTasksTodayList();
        requestScope("tasksTodayList", tasksTodayList);
        return forward("todays_task.jsp");
    }

}
