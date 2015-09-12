package taskmanagement.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
/**
 * Model for Task kind
 * @author David Ramirez
 * @version 0.01
 * Version History
 * [07/26/2015] 0.01 – David Ramirez – Initial codes
 * [07/27/2015] 0.02 - Jacquelyn Amaya - Added userId, doneRatio, and estRatio members with getters and setters
 * [08/07/2015] 0.03 - Jacquelyn Amaya - Added data members (spentHours, isFinished, isPending, isToday) and comments
 **/
@Model(schemaVersion = 1)
public class Task implements Serializable {
/**
 * -------------------------------------------------------
 * PRIVATE MEMBERS
 * -------------------------------------------------------
 */
    private static final long serialVersionUID = 1L;
    /**
     * Task primary key
     */
    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    /**
     * Task attribute id
     */
    private Long id;
    
    /**
     * User's id
     */
    private long userId;
    
    /**
     * Task name
     */
    private String name;
    
    /**
     * Task phase
     */
    private String phase;
    
    /**
     * Estimated hours of Task
     */
    private double estHours;
    
    /**
     * Start Date of Task
     */
    private String startDate;
    
    /**
     * Due Date of Task
     */
    private String dueDate;
    
    /**
     * Task spent hours
     */
    private double spentHours;
    
    /**
     * Task isFinished
     */
    private boolean isFinished;
    
    /**
     * Task isPending
     */
    private boolean isPending;
    
    /**
     * Task isToday
     */
    private boolean isToday;
    
       

/**
 * -------------------------------------------------------
 * GETTERS AND SETTERS
 * -------------------------------------------------------
 */
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
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
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
    
    /**
     * returns id of task
     * @return id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * sets id of task with param id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * returns id of user
     * @return userId
     */
    public long getUserId() {
        return userId;
    }
    
    /**
     * sets id of user
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    /**
     * returns name of task
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * sets name of task
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * returns phase of task
     * @return phase
     */
    public String getPhase() {
        return phase;
    }
    
    /**
     * sets phase of task
     * @param phase
     */
    public void setPhase(String phase) {
        this.phase = phase;
    }
        
    /**
     * returns estimated hours of task
     * @return estHours
     */
    public double getEstHours() {
        return estHours;
    }
    
    /**
     * sets estimated hours of task
     * @param estHours
     */
    public void setEstHours(double estHours) {
        this.estHours = estHours;
    }
    
    /**
     * returns start date of task
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }
    
    /**
     * sets start date of task
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    /**
     * returns due date of task
     * @return dueDate
     */
    public String getDueDate() {
        return dueDate;
    }
    
    /**
     * sets due date of task
     * @param dueDate
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    
    /**
     * returns spent hours of task
     * @return spentHours
     */
    public double getSpentHours() {
        return spentHours;
    }
    
    /**
     * sets spent hours of task
     * @param spentHours
     */
    public void setSpentHours(double spentHours) {
        this.spentHours = spentHours;
    }
    
    /**
     * returns true if task is finished; else, returns false
     * @return isFinished
     */
    public boolean isFinished() {
        return isFinished;
    }
    
    /**
     * sets isFinished to true or false
     * @param isFinished
     */
    public void setFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
    
    /**
     * returns true if task is pending; else, returns false
     * @return
     */
    public boolean isPending() {
        return isPending;
    }
    
    /**
     * sets isPending to true or false
     * @param isPending
     */
    public void setPending(boolean isPending) {
        this.isPending = isPending;
    }
    
    /**
     * returns true if task is today; else, returns false
     * @return
     */
    public boolean isToday() {
        return isToday;
    }
    
    /**
     * sets isToday to true or false
     * @param isToday
     */
    public void setToday(boolean isToday) {
        this.isToday = isToday;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
