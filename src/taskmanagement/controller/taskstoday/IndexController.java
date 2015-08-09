/**
 * 
 */
package taskmanagement.controller.taskstoday;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import taskmanagement.dto.TaskClientDto;
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
        TaskClientDto taskList = new TaskClientDto();
        JSONObject json = new JSONObject();
        try {
            taskList = service.getTasksTodayList();
        } catch (Exception e) {
            e.printStackTrace();
            taskList.getErrorList().add("Server controller error: " + e.getMessage());
        }
        
        json.put("taskList", taskList.getTaskList());
        json.put("errorList", taskList.getErrorList());
        response.setContentType("application/json");
        response.getWriter().write(json.toString());
        return null;
        /*List<TaskDay> tasksTodayList = service.getTasksTodayList();
        requestScope("tasksTodayList", tasksTodayList);
        return forward("todays_task.jsp");*/
    }

}
