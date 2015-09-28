package taskmanagement.controller;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class SinglePageController extends Controller {

    @Override
    protected Navigation run() throws Exception {
        System.out.println(sessionScope("userId"));
        if (null != sessionScope("userId")) {
            return forward("singlepage.jsp");
        } else {
            return forward("index.jsp");
        }
        
    }

}
