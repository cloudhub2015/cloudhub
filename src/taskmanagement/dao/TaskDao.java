/**
 * 
 */
package taskmanagement.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import taskmanagement.meta.TaskMeta;
import taskmanagement.model.Task;

/**
 * DAO used to access the datastore for task transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class TaskDao {
    
    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of tasks.
     */
    public List<Task> getAllTasks() {
        TaskMeta t = new TaskMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
        return Datastore.query(t ,parentKey).asList();
    }
    
    /**
     * Method used to save a task
     * @param taskModel - task to be saved
     * @return Boolean - true, if task is saved; otherwise, false.
     */
    public boolean saveTask(Task taskModel) {
        boolean result = true;
        try {
            Transaction tx = Datastore.beginTransaction();
            //Manually allocate key
            Key key = Datastore.allocateId(KeyFactory.createKey("Account", "Default"), "Task");
            taskModel.setKey(key);
            taskModel.setId(key.getId());
            Datastore.put(taskModel);
            tx.commit();
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
    

    /**
     * Method used to update a task
     * @param taskModel - task to be updated
     * @return Boolean - true, if task is updated; otherwise, false.
     */
    public boolean updateTask(Task taskModel) {
        boolean result = true;
        TaskMeta tm = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, taskModel.getId());

        try {
            Task originalTaskModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalTaskModel != null) {
                originalTaskModel.setCreatedDate(taskModel.getCreatedDate());
                originalTaskModel.setContent(taskModel.getContent());
                Transaction tx = Datastore.beginTransaction();
                Datastore.put(originalTaskModel);
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
     * Method used to delete a task
     * @param taskModel - task to be deleted
     * @return Boolean - true, if task is deleted; otherwise, false.
     */
    public boolean deleteTask(Task taskModel) {
        boolean result = true;
        TaskMeta tm = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, taskModel.getId());

        try {
            Task originalTaskModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalTaskModel != null) {
                Transaction tx = Datastore.beginTransaction();
                Datastore.delete(originalTaskModel.getKey());
                tx.commit();
            } else {
                result = false;
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }
}
