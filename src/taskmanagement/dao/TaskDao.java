package taskmanagement.dao;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.FilterCriterion;

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
 * [08/07/2015] 0.02 - Jacquelyn Amaya - Added searchTasks method and methods for taskstoday controllers
 */
public class TaskDao {
/**
 * --------------------------------------------------------------------
 * For Task Controllers
 * --------------------------------------------------------------------
 */    
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
     * Method used to retrieve a task to edit
     * @return Task
     */
    public Task getTask(long id) {
        TaskMeta taskMeta = new TaskMeta();
        FilterCriterion mainFilter = taskMeta.id.equal(id);
        return Datastore.query(taskMeta).filter(mainFilter).asSingle();
    }
    
    /**
     * Method used to set isFinished attribute of task to true
     * @return boolean
     */
    public boolean setCompletedTask(Long id) {
        boolean result=true;
        TaskMeta t = new TaskMeta();
        Task task = new Task();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, id);
        
        try {
            task = Datastore.query(t).filter(mainFilter).asSingle();
            
            if (task != null) {
                Transaction tx = Datastore.beginTransaction();
                task.setFinished(true);
                Datastore.put(task);
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
     * Method used to set isToday attribute of task to true
     * @return boolean
     */
    public boolean setTodaysTask(Long id) {
        boolean result=true;
        TaskMeta t = new TaskMeta();
        Task task = new Task();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, id);
        
        try {
            task = Datastore.query(t).filter(mainFilter).asSingle();
            
            if (task != null) {
                Transaction tx = Datastore.beginTransaction();
                task.setToday(true);
                Datastore.put(task);
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
     * Method used to retrieve tasks searched by the client.
     * @return List<Task> - list of tasks.
     */
    public List<Task> searchTasks(String name) {
        TaskMeta t = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("name", FilterOperator.IN, name);
        return Datastore.query(t).filter(mainFilter).asList();
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
        FilterCriterion mainFilter = tm.id.equal(taskModel.getId());

        try {
            Task originalTaskModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalTaskModel != null) {
                originalTaskModel.setName(taskModel.getName());
                originalTaskModel.setPhase(taskModel.getPhase());
                originalTaskModel.setEstHours(taskModel.getEstHours());
                originalTaskModel.setStartDate(taskModel.getStartDate());
                originalTaskModel.setDueDate(taskModel.getDueDate());
                originalTaskModel.setSpentHours(taskModel.getSpentHours());
                originalTaskModel.setFinished(taskModel.isFinished());
                originalTaskModel.setPending(taskModel.isPending());
                originalTaskModel.setToday(taskModel.isToday());
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

/**
 * --------------------------------------------------------------------
 * For Tasks Today Controllers
 * --------------------------------------------------------------------
 */
    /**
     * Method used to retrieve tasks for today
     * @return List<Task> - list of tasks.
     */
    public List<Task> getTodaysTasks() {
        TaskMeta t = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("today", FilterOperator.EQUAL, true);
        return Datastore.query(t).filter(mainFilter).asList();
    }
    
    /**
     * Method used to retrieve pending tasks
     * @return List<Task> - list of tasks.
     */
    public List<Task> getPendingTasks() {
        TaskMeta t = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("pending", FilterOperator.EQUAL, true);
        return Datastore.query(t).filter(mainFilter).asList();
    }
    
    /**
     * Method used to retrieve finished tasks
     * @return List<Task> - list of tasks.
     */
    public List<Task> getFinishedTasks() {
        TaskMeta t = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("finished", FilterOperator.EQUAL, true);
        return Datastore.query(t).filter(mainFilter).asList();
    }
}
