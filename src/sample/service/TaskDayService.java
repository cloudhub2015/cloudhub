package sample.service;

import java.util.List;

import sample.dao.TaskDayDao;
import sample.dto.TaskDayDto;
import sample.model.Task;
import sample.model.TaskDay;

/**
 * DAO used to access the datastore for task day transactions
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class TaskDayService {
    /**
     * The TaskDao to use.
     * Holds the method for transacting with the datastore.
     */
    TaskDayDao dao = new TaskDayDao();
    
    
    /**
     * Method used to add a task day.
     * @param input - task day to add.
     * @return TaskDayDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDayDto addTaskDay(TaskDayDto input) {
        /*Task tweet = new Tweet();
        tweet.setCreatedDate(input.getCreatedDate());
        tweet.setContent(input.getContent());

        if(!this.dao.saveTweet(tweet)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }*/
        return input;
    }

    /**
     * Method used to update a task day.
     * @param input - task day to update.
     * @return TaskDayDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDayDto updateTaskDay(TaskDayDto input) {
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
     * Method used to delete a task day.
     * @param input - task day to delete.
     * @return TaskDayDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDayDto deleteTaskDay(TaskDayDto input) {
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

    public List<TaskDay> getTasksTodayList() {
      //   return this.dao.getAll;
        return null;
    }
}
