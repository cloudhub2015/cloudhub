package taskmanagement.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO used to store multiple tasks for client side operations.
 * @author Jacquelyn Amaya
 * @version 0.01
 * Version History
 * [08/07/2015] 0.01 – Jacquelyn Amaya – Initial codes
 */
public class TaskClientDto {
    /**
     * List of errors.
     */
    private List<String> errorList = new ArrayList<String>();

    /**
     * List of tasks.
     */
    private List<TaskDto> taskList = new ArrayList<TaskDto>();
    
    /**
     * Retrieves errorList
     * @return the errorList
     */
    public List<String> getErrorList() {
        return errorList;
    }
    
    /**
     * Sets errorList
     * @param errorList
     */
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    
    /**
     * Retrieves list of tasks
     * @return
     */
    public List<TaskDto> getTaskList() {
        return taskList;
    }
    
    /**
     * Sets list of tasks
     * @param taskList
     */
    public void setTaskList(List<TaskDto> taskList) {
        this.taskList = taskList;
    }
}
