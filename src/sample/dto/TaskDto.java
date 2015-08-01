package sample.dto;

import java.util.Date;
import java.util.List;

/**
<<<<<<< HEAD:src/sample/dto/TaskInformationDTO.java
 * DTO used to store a single task information for
 * client side operations.
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [07/26/2015] 0.01 – David Ramirez – Initial codes.
=======
 * Data transfer object for Task entity
 * @author David Ramirez
 * @version 0.01
 * [07/27/2015] 0.01 - David Ramirez - Initial codes
 * [07/27/2015] 0.02 - Jacquelyn Amaya - Added userId, doneRation, and estRatio members with getters and setters
>>>>>>> 4ab7caed0fefa54a46edb4fa4860a414ffde077f:src/sample/dto/TaskDto.java
 */
public class TaskDto {
    private long id;
    private List<String> errorList;
    private String name;
    private String createdDate = new Date().toString();
    private String phase;
    private long userId;
    private int doneRatio;
    private float estHours;
    private String content;
    
    
    public List<String> getErrorList() {
        return errorList;
    }
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    public String getTaskName() {
        return name;
    }
    public String getPhase(){
        return phase;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public void setPhase(String phase){
        this.phase = phase;
    }
    
    public void setTaskName(String name) {
        this.name = name;
    }
    public String getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public int getDoneRatio() {
        return doneRatio;
    }
    public void setDoneRatio(int doneRatio) {
        this.doneRatio = doneRatio;
    }
    public float getEstHours() {
        return estHours;
    }
    public void setEstHours(float estHours) {
        this.estHours = estHours;
    }
}
