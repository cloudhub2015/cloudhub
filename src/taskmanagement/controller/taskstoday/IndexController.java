/**
 * 
 */
package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import taskmanagement.service.TaskService;

/**
 * Initial Controller to display all Today's Tasks
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/08/2015] 0.02 - Jacquelyn Amaya - Implemented retrieving all today's tasks using JSON
 */
public class IndexController extends Controller {

    /**
     * The TaskDayService to use.
     * Holds the method for retrieving list of today's tasks.
     */
    TaskService service = new TaskService();

    @Override
    public Navigation run() throws Exception {
        return forward("todays_task.jsp");
    }

}
