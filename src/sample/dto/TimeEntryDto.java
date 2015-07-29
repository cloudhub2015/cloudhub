package sample.dto;

/**
 * Data transfer object for Time Entry entity
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class TimeEntryDto {
    private long id;
    private long taskId;
    private long userId;
    private float hours;
    private String comments;
    private String spentOn;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getTaskId() {
        return taskId;
    }
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public float getHours() {
        return hours;
    }
    public void setHours(float hours) {
        this.hours = hours;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getSpentOn() {
        return spentOn;
    }
    public void setSpentOn(String spentOn) {
        this.spentOn = spentOn;
    }
}
