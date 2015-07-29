package sample.service;

import java.util.List;

import sample.dao.TaskDao;
import sample.dto.TaskDto;
import sample.model.Task;

public class TimeEntriesService {
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
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of tweets.
     */
    public List<Task> getTaskList() {
        return this.dao.getAllTasks();
    }

    /**
     * Method used to update a tweet.
     * @param input - tweet to update.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto updateTask(TaskDto input) {
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
