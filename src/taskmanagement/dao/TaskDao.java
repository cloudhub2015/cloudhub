package taskmanagement.dao;

import java.util.Calendar;
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
 * [09/13/2015] 0.03 - Jacquelyn Amaya - Added updateTaskToday(), deleteTodaysTask() and setTodaysTask() methods
 * [09/28/2015] 0.04 - Jacquelyn Amaya - Add task to current date
 *                                     - Maximum spent hours per day: 8
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
    public List<Task> getAllTasks(long userId) {
        TaskMeta t = new TaskMeta();
        Key parentKey = KeyFactory.createKey("Account", "Default");
        Query.Filter mainFilter = new Query.FilterPredicate("userId", FilterOperator.EQUAL, userId);
        return Datastore.query(t, parentKey).filter(mainFilter).asList();        
    }
    
    /**
     * Method used to retrieve a task to edit
     * @param id - get task by ID
     * @return Task
     */
    public Task getTask(long id) {
        TaskMeta taskMeta = new TaskMeta();
        FilterCriterion taskFilter = taskMeta.id.equal(id);
        return Datastore.query(taskMeta).filter(taskFilter).asSingle();
    }
    
    /**
     * Method used to retrieve a task to edit
     * @param name - get Task by name
     * @return Task
     */
    public Task getTask(String name) {
        TaskMeta taskMeta = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("name", FilterOperator.EQUAL, name);
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
                task.setPending(false);
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
     * Method used to set isToday attribute of task to false
     * @return boolean
     */
    public boolean deleteTodaysTask(Long id) {
        boolean result=true;
        TaskMeta t = new TaskMeta();
        Task task = new Task();
        Query.Filter mainFilter = new Query.FilterPredicate("id", FilterOperator.EQUAL, id);
        
        try {
            task = Datastore.query(t).filter(mainFilter).asSingle();
            
            if (task != null) {
                Transaction tx = Datastore.beginTransaction();
                task.setToday(false);
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
     * Method used to update today's task
     * @return boolean
     */
    public boolean updateTaskToday(Task taskModel) {
        boolean result = true;
        TaskMeta tm = new TaskMeta();
        FilterCriterion mainFilter = tm.id.equal(taskModel.getId());

        try {
            Task originalTaskModel = Datastore.query(tm).filter(mainFilter).asSingle();
            if (originalTaskModel != null) {
                originalTaskModel.setSpentHours(originalTaskModel.getSpentHours() + taskModel.getSpentHours());
                originalTaskModel.setCurrentDate(getCurrentDate());
                originalTaskModel.setFinished(taskModel.isFinished());
                originalTaskModel.setPending(taskModel.isPending());
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
     * Returns a Date object that doesn't contain time information
     * @return the date today
     */
    public static long getCurrentDate () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.AM_PM, Calendar.AM);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
    
    /**
     * Method used to save a task
     * @param taskModel - task to be saved
     * @return Boolean - true, if task is saved; otherwise, false.
     */
    public boolean saveTask(Task taskModel) throws Exception{
        boolean result = true;
        try {
            if(getTask(taskModel.getName()) == null){
                Transaction tx = Datastore.beginTransaction();
                //Manually allocate key
                Key key = Datastore.allocateId(KeyFactory.createKey("Account", "Default"), "Task");
                taskModel.setKey(key);
                taskModel.setId(key.getId());
                Datastore.put(taskModel);
                tx.commit();
            }
            
            else
                throw new Exception("Task Already Added");
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
            if(getTask(taskModel.getName()) == null){
                Task originalTaskModel = Datastore.query(tm).filter(mainFilter).asSingle();
                if (originalTaskModel != null) {
                    originalTaskModel.setName(taskModel.getName());
                    originalTaskModel.setPhase(taskModel.getPhase());
                    originalTaskModel.setEstHours(taskModel.getEstHours());
                    originalTaskModel.setCurrentDate(taskModel.getCurrentDate());
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
    public List<Task> getTasksForToday() {
        TaskMeta t = new TaskMeta();
        Query.Filter mainFilter = new Query.FilterPredicate("currentDate", FilterOperator.EQUAL, getCurrentDate());
        return Datastore.query(t).filter(mainFilter).asList();
    }
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
