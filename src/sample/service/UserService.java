package sample.service;

import java.util.ArrayList;

import sample.dao.UserDao;
import sample.dto.UserDto;
import sample.model.User;

/**
 * DAO used to access the datastore for user transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
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
        user.setEmail(input.getEmail());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setUsername(input.getUsername());
        user.setPassword(input.getPassword());
        user.setTelephone(input.getTelephone());
        
        if(!this.dao.saveUser(user)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        
        return input;
    }

}
