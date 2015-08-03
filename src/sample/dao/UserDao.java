package sample.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;

import sample.model.User;

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
}
