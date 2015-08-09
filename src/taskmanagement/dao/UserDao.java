package taskmanagement.dao;


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
        
    public boolean checkUser(User userModel) {
        boolean result = false;
        UserMeta tm = new UserMeta();
        Query.Filter userFilter = new Query.FilterPredicate("username", FilterOperator.EQUAL, userModel.getUsername());
        Query.Filter passwordFilter = new Query.FilterPredicate("password", FilterOperator.EQUAL, userModel.getPassword());
        try {
            User originalUserNameModel = Datastore.query(tm).filter(userFilter).asSingle();
            User originalPasswordModel = Datastore.query(tm).filter(passwordFilter).asSingle();
            if (originalUserNameModel != null && originalPasswordModel != null) {
                   if(originalUserNameModel.getId() == originalPasswordModel.getId()){
                       result = true;
                   }
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
