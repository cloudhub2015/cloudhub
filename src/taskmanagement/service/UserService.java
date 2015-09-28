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
 * [09/13/2015] 0.03 - Jacquelyn Amaya - Added getUser() method with id as parameter
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
            input.getErrorList().add("User Validation Error: ");
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
    
    /**
     * Method used to retrieve user
     * @param input
     * @return UserDto - if transaction was unsuccessful, contains list of errors.
     */
    public UserDto getUser(String username) {        
        User user = this.dao.getUser(username);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
    
    /**
     * Method used to retrieve user using id
     * @param id
     * @return User
     */
    public User getUser(long id) {
        return this.dao.getUser(id);
    }
    
    /**
     * Method used to update a task.
     * @param input - task to update.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public UserDto updateUser(UserDto input) {
        User user = new User();
        user.setId(input.getId());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        
        if(!this.dao.updateUser(user)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("Database Error!");
        }

        return input;
    }
}
