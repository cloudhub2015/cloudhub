package taskmanagement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private Long id;
    
    private String content;
    private List<String> errorList;
    private String name;
    private String phase;
    private long userId;
    private int doneRatio;
    private float estHours;
    private String startDate;
    private String dueDate;
    
    /**
     * Task created date.
     */
    private String createdDate = new Date().toString();
    
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
    
    public String getStartDate(){
        return startDate;
    }
    
    public String getDueDate(){
        return dueDate;
    }
    
    public void setStartDate(String startDate){
        this.startDate = startDate;
    }
    
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    public void setPhase(String phase){
        this.phase = phase;
    }
    
    public void setTaskName(String name) {
        this.name = name;
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
    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }
    
    /**
     * Returns the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id.
     */
    public void setId(Long id) {
        this.id = id;
    }
    

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }
    
    /**
     * Get createdDate.
     */
    public String getCreatedDate() {
        return createdDate;
    }
    
    
    /**
     * Get content.
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Set content.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Set createdDate.
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
