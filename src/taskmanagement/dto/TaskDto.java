package taskmanagement.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO used to store a single task information for
 * client side operations.
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [07/26/2015] 0.01 – David Ramirez – Initial codes.
 * [07/27/2015] 0.02 - Jacquelyn Amaya - Added userId, doneRatio, and estRatio members with getters and setters
 * [08/05/2015] 0.03 - David Ramirez - Comments
 * [08/07/2015] 0.04 - Jacquelyn Amaya - Added spentHours member
 **/
public class TaskDto {
/**
 * -------------------------------------------------------
 * PRIVATE MEMBERS
 * -------------------------------------------------------
 */
    /*
     *  Task ID 
     */
    private long id;
    /*
     *  List of Errors
     */
    private List<String>  errorList = new ArrayList<String>();
    /*
     *  Task Name
     */
    private String name;
    /*
     *  Task Phase
     */
    private String phase;
    /*
     *  User ID 
     */
    private long userId;
    /*
     *  Estimated Hours to Accomplish
     */
    private double estHours;
    /*
     * Hours spent by this task
     */
    private double spentHours;
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
    
    private long currentDate;

 /**
 * -------------------------------------------------------
 * GETTERS AND SETTERS
 * -------------------------------------------------------
 */    
    
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
     *  @return estHours - retrieves the estimated hours of the task
     */
    public double getEstHours() {
        return estHours;
    }
    /*
     *  @param userId - sets the estimated hours of the task
     */
    public void setEstHours(double estHours) {
        this.estHours = estHours;
    }
    /*
     * @return spentHours of task
     */
    public double getSpentHours() {
        return spentHours;
    }
    /*
     * @param spentHours
     * sets the spent hours of task
     */
    public void setSpentHours(double spentHours) {
        this.spentHours = spentHours;
    }
    public long getCurrentDate() {
        return currentDate;
    }
    public void setCurrentDate(long currentDate) {
        this.currentDate = currentDate;
    }
}
