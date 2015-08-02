package sample.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * Controller for the user to login
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class LogInController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        return forward("index.jsp");
    }

}
