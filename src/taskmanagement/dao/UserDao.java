package taskmanagement.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import taskmanagement.meta.UserMeta;
import taskmanagement.model.User;

/**
 * DAO used to access the datastore for user transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [09/13/2015] 0.02 - Jacquelyn Amaya - Code Documentation
 */
public class UserDao {
    /**
     * Method used to save user
     * @param userModel - user to be saved
     * @return Boolean - true, if user is saved; otherwise, false.
     */
    public boolean saveUser(User userModel) {
        boolean result = true;
        try {
            Transaction tx = Datastore.beginTransaction();
            //Manually allocate key
            Key key = Datastore.allocateId(KeyFactory.createKey("Account", "Default"), "User");
            userModel.setKey(key);
            userModel.setId(key.getId());
            Datastore.put(userModel);
            tx.commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Method used to update a user
     * @param userModel - task to be updated
     * @return Boolean - true, if task is updated; otherwise, false.
     */
    
    public boolean updateUser(User userModel) {
        boolean result = true;
        UserMeta tm = new UserMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, userModel.getId());

        try {
            User originalUserModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalUserModel != null) {
                originalUserModel.setFirstName(userModel.getFirstName());
                originalUserModel.setLastName(userModel.getLastName());
                originalUserModel.setUsername(userModel.getUsername());
                originalUserModel.setPassword(userModel.getPassword());
                Transaction tx = Datastore.beginTransaction();
                Datastore.put(originalUserModel);
                tx.commit();
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Method used to delete a user
     * @param userModel - user to be deleted
     * @return Boolean - true, if task is deleted; otherwise, false.
     */
    public boolean deleteUser(User userModel) {
        boolean result = true;
        UserMeta tm = new UserMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, userModel.getId());

        try {
            User originalUserModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalUserModel != null) {
                Transaction tx = Datastore.beginTransaction();
                Datastore.delete(originalUserModel.getKey());
                tx.commit();
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public List<User> getAllUsers() {
        UserMeta t = new UserMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
        return Datastore.query(t ,parentKey).asList();
    }
    
    /**
     * Method used to validate the user
     * @param userModel
     * @return boolean result
     */
    public boolean checkUser(User userModel) {
        boolean result = false;
        UserMeta tm = new UserMeta();
        Query.Filter userFilter = new Query.FilterPredicate("username", FilterOperator.EQUAL, userModel.getUsername());
        try {
            User originalUserModel = Datastore.query(tm).filter(userFilter).asSingle();
            if ((originalUserModel.getUsername().equals(userModel.getUsername())) && (originalUserModel.getPassword().equals(userModel.getPassword()))) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Method used to retrieve user using username
     * @param username
     * @return User
     */
    public User getUser(String username) {
        UserMeta tm = new UserMeta();
        Query.Filter userFilter = new Query.FilterPredicate("username", FilterOperator.EQUAL, username);
        return Datastore.query(tm).filter(userFilter).asSingle();
    }
    
    /**
     * Method used to retrieve using id
     * @param id
     * @return User
     */
    public User getUser(long id) {
        UserMeta tm = new UserMeta();
        Query.Filter userFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, id);
        return Datastore.query(tm).filter(userFilter).asSingle();
    }
}
