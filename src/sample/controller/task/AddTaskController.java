package sample.controller.task;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Controller to add task
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class AddTaskController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("AddTaskInformation.jsp");
    }
}
