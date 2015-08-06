package taskmanagement.dto;

/**
 * Data transfer object for Task Day entity
 * @author Jacquelyn Amaya
 * @version 0.01
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 */
public class TaskDayDto {
    /*
     *  Task Id
     */
    private long taskId;
    /* 
     *  Task start date
     */
    private String startDate;
    /*
     *  Task due date
     */
    private String dueDate;
    /*
     *  Task user id
     */
    private long userId;
    
    /*
     * Retrieves the Task id
     * @return the taskId
     */
    public long getTaskId() {
        return taskId;
    }
    
    /*
     * Sets the Task id
     * @param id the taskId
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
    
    /*
     * Retrieves the start date
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }
    
    /*
     * Sets the start date
     * @param startDate sets the start date of a task
     */
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    /*
     * Retrieves the due date
     * @return the due date
     */
    public String getDueDate() {
        return dueDate;
    }
    
    /*
     * Sets the due date
     * @param dueDate sets the due date of a task
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    /*
     * Retrieves the user Id
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }
    
    /*
     * Sets the user Id
     * @param userId sets the userId of a task
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
}
