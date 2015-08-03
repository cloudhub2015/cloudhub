package sample.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import sample.dao.TaskDao;
import sample.dto.TaskDto;
import sample.model.Task;

/**
 * DAO used to access the datastore for task transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/02/2015] 0.02 - David Ramirez   - add, update and delete tasks
 */
public class TaskService {
    /**
     * The TaskDao to use.
     * Holds the method for transacting with the datastore.
     */
    TaskDao dao = new TaskDao();
    
    
    /**
     * Method used to add a task.
     * @param input - task to add.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto addTask(TaskDto input) {
        Task task = new Task();
        task.setCreatedDate(input.getCreatedDate());
        task.setContent(input.getContent());

        if(!this.dao.saveTask(task)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        return input;
    }

    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of tweets.
     */
    public List<Task> getTaskList() {
        return this.dao.getAllTasks();
    }

    /**
     * Method used to update a task.
     * @param input - task to update.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto updateTask(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        task.setCreatedDate(Calendar.getInstance().getTime().toString());
        task.setContent(input.getContent());
        
        if(!this.dao.updateTask(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        /*Tweet tweet = new Tweet();
        tweet.setId(input.getId());
        tweet.setCreatedDate(Calendar.getInstance().getTime().toString());
        tweet.setContent(input.getContent());

        if(!this.dao.updateTask(tweet)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }*/

        return input;
    }

    /**
     * Method used to delete a task.
     * @param input - task to delete.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto deleteTask(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        task.setCreatedDate(Calendar.getInstance().getTime().toString());
        task.setContent(input.getContent());
        
        if(!this.dao.deleteTask(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        
        /*Tweet tweet = new Tweet();
        tweet.setId(input.getId());
        tweet.setCreatedDate(input.getCreatedDate());
        tweet.setContent(input.getContent());

        if(!this.dao.deleteTweet(tweet)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }*/

        return input;
    }
}
