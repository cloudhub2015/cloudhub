package taskmanagement.controller.user;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class VerifyUserController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("index.jsp");
    }
}
