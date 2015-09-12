package taskmanagement.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class SinglePageController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        // TODO Auto-generated method stub
        return forward("singlepage.jsp");
    }

}
