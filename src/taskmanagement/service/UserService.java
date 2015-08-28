package taskmanagement.service;

import java.util.ArrayList;
import java.util.List;

import taskmanagement.dao.UserDao;
import taskmanagement.dto.UserDto;
import taskmanagement.model.User;

/**
 * DAO used to access the datastore for user transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/27/2015] 0.02 - Jacquelyn Amaya - Edited validateUser() method
 */
public class UserService {
    /**
     * The UserDao to use.
     * Holds the method for transacting with the datastore.
     */
    UserDao dao = new UserDao();
    
    
    /**
     * Method used to add a user.
     * @param input - user to add.
     * @return UserDto - if transaction was unsuccessful, contains list of errors.
     */
    public UserDto addUser(UserDto input) {        
        User user = new User();
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        
        if(!this.dao.saveUser(user)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        return input;
    }
    
    /**
     * Method used to validate user when logging in
     * @param input
     * @return UserDto - if transaction was unsuccessful, contains list of errors.
     */
    public UserDto validateUser(UserDto input) {        
        User user = new User();
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        
        if(!this.dao.checkUser(user)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("Invalid username or password");
        }
        return input;
    }
    
    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of Tasks.
     */
    public List<User> getUsersList() {
        return this.dao.getAllUsers();
    }

}
