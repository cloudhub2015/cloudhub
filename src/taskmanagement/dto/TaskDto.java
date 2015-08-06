package taskmanagement.dto;

import java.util.Date;
import java.util.List;

/**
 * DTO used to store a single task information for
 * client side operations.
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [07/26/2015] 0.01 – David Ramirez – Initial codes.
 * [07/27/2015] 0.02 - Jacquelyn Amaya - Added userId, doneRation, and estRatio members with getters and setters
 * [08/05/2015] 0.03 - David Ramirez - Comments
 **/
public class TaskDto {
    /*
     *  Task ID 
     */
    private long          id;
    /*
     *  List of Errors
     */
    private List<String>  errorList;
    /*
     *  Task Name
     */
    private String        name;
    /*
     *  Date Created
     */
    private String        createdDate = new Date().toString();
    /*
     *  Task Phase
     */
    private String  phase;
    /*
     *  User ID 
     */
    private long    userId;
    /*
     *  Done Ratio
     */
    private int     doneRatio;
    /*
     *  Estimated Hours to Accomplish
     */
    private float   estHours;
    /*
     *  Content manage
     */
    private String  content;
    /*
     *  Date Started
     */
    private String  startDate;
    /*
     *  Expected Due Date
     */
    private String  dueDate;
    /*
     *  Finish Flag
     */
    private boolean isFinished;
    /*
     *  Pending Flag
     */
    private boolean isPending;
    /*
     *  Today Flag
     */
    private boolean isToday;
    /*
     * Hours spent by this task
     */
    private int spentOn;
    
    /*
     *  @return isPending - returns TRUE if task is PENDING otherwise FALSE
     */
    public boolean isPending(){
        return isPending;
    }
    /*
     *  @param isPending - if Task is PENDING return TRUE otherwise FALSE
     */
    public void setPending(boolean isPending){
        this.isPending = isPending;
    }
    
    /*
     *  @return isToday - returns TRUE if task is TODAY otherwise FALSE
     */
    public boolean isToday(){
        return isToday;
    }
    /*
     *  @param isToday - if Task is TODAY return TRUE otherwise FALSE
     */
    public void setToday(boolean isToday){
        this.isToday = isToday;
    }
    
    
    /*
     *  @return isFinished - returns TRUE if task is finished otherwise FALSE
     */
    public boolean isFinished(){
        return isFinished;
    }
    /*
     *  @param isFinished - if Task is FINISHED return TRUE otherwise FALSE
     */
    public void setFinished(boolean isFinished){
        this.isFinished = isFinished;
    }
    
    /*
     *  @return errorList - returns a List Objects 
     */
    public List<String> getErrorList() {
        return errorList;
    }
    /*
     *  @param errorList - list of errors
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    /*
     *  @return taskName - retrieves the name of the task
     */
    public String getTaskName() {
        return name;
    }
    /*
     *  @return taskPhase - retrieves the current phase
     */
    public String getPhase(){
        return phase;
    }
    /*
     *  @return startDate - retrieves the start date of a task
     */
    public String getStartDate(){
        return startDate;
    }
    /*
     *  @return dueDate - retrieves the end date of a task
     */
    public String getDueDate(){
        return dueDate;
    }
    /*
     *  @param startDate - sets the start date of a task
     */
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    /*
     *  @param dueDate - sets the end date of a task
     */
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
    /*
     *  @param content - retrieves the content of the Task Class
     */
    public String getContent(){
        return content;
    }
    /*
     *  @param content - sets the content of the Task Class
     */
    public void setContent(String content){
        this.content = content;
    }
    /*
     *  @param phase - sets the current phase of the task
     */
    public void setPhase(String phase){
        this.phase = phase;
    }
    /*
     *  @param name - sets the name of the task
     */
    public void setTaskName(String name) {
        this.name = name;
    }
    /*
     *  @return createdDate - retrieves the creation day of the task
     */
    public String getCreatedDate() {
        return createdDate;
    }
    /*
     *  @param createdDate - sets the creation day of the task
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    /*
     *  @return id - retrieves the ID of the task
     */
    public long getId() {
        return id;
    }
    /*
     *  @param id - sets the ID of the task
     */
    public void setId(long id) {
        this.id = id;
    }
    /*
     *  @return name - retrieves the name of the task
     */
    public String getName() {
        return name;
    }
    /*
     *  @param name - sets the name of the task
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
     *  @return userId - retrieves the user id of the task
     */
    public long getUserId() {
        return userId;
    }
    /*
     *  @param userId - sets the userId of the task
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
    /*
     *  @return doneRatio - retrieves the done ratio of the task
     */
    public int getDoneRatio() {
        return doneRatio;
    }
    /*
     *  @param doneRatio - sets the doneRatio of the task
     */
    public void setDoneRatio(int doneRatio) {
        this.doneRatio = doneRatio;
    }
    /*
     *  @return estHours - retrieves the estimated hours of the task
     */
    public float getEstHours() {
        return estHours;
    }
    /*
     *  @param userId - sets the estimated hours of the task
     */
    public void setEstHours(float estHours) {
        this.estHours = estHours;
    }
}
