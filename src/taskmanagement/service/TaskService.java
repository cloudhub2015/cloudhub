package taskmanagement.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import taskmanagement.dao.TaskDao;
import taskmanagement.dto.TaskClientDto;
import taskmanagement.dto.TaskDto;
import taskmanagement.model.Task;

/**
 * Service for Task
 * @author Jacquelyn Amaya
 * @version 0.01 
 * Version History
 * [07/27/2015] 0.01 - Jacquelyn Amaya - Initial codes
 * [08/02/2015] 0.02 - David Ramirez   - add, update and delete tasks
 * [08/08/2015] 0.03 - Jacquelyn Amaya - Updated addTask function, modified getTaskList method,
 *                                     - Added methods to retrieve today's, pending, and finished tasks
 * [08/17/2015] 0.04 - David Ramirez   - Code Documentation
 * [09/13/2015] 0.05 - Jacquelyn Amaya - Replaced selectTask method with getTask method to return Task instead of TaskDto
 *                                     - Added deleteTaskToday() and updateTaskToday() methods
 */
public class TaskService {
/**
 * --------------------------------------------------------------------
 * For Task Controllers
 * --------------------------------------------------------------------
 */    
    /**
     * The TaskDao to use.
     * Holds the method for transacting with the datastore.
     */
    private TaskDao dao = new TaskDao();
    
    
    /**
     * Method used to add a task.
     * @param input - taskDto to add.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     * @throws Exception 
     */
    public TaskDto addTask(TaskDto input) throws Exception {
        Task task = new Task();

            task.setId(input.getId());
            task.setUserId(input.getUserId());
            task.setName(input.getName());
            task.setPhase(input.getPhase());
            task.setEstHours(input.getEstHours());
            task.setFinished(input.isFinished());
            task.setPending(input.isPending());
            task.setToday(input.isToday());
            
            if(!this.dao.saveTask(task)) {
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("Error: Task Already Added");
            }
        return input;
    }

    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getTaskList(long userId) {
        List<Task> taskModels = this.dao.getAllTasks(userId);
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setCurrentDate(task.getCurrentDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }
    
    /**
     * Method used to check list of unfinished tasks.
     * @return Date - returns the date with time 00:00:00
     */
    
    public Date trim(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);

        return calendar.getTime();
    }
    
    /**
     * Method used to retrieve list of todays tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getTodaysTaskList(long userId) {
        List<Task> taskModels = this.dao.getAllTasks(userId);
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;
        
        for (Task task : taskModels) {
            if(task.isToday() && !(task.isFinished())){
                taskDto = new TaskDto();
                taskDto.setId(task.getId());
                taskDto.setUserId(task.getUserId());
                taskDto.setName(task.getName());
                taskDto.setPhase(task.getPhase());
                taskDto.setEstHours(task.getEstHours());
                taskDto.setCurrentDate(task.getCurrentDate());
                taskDto.setSpentHours(task.getSpentHours());
                taskDto.setFinished(task.isFinished());
                taskDto.setPending(task.isPending());
                taskDto.setToday(task.isToday());
                taskList.getTaskList().add(taskDto);
            }
        }

        return taskList;
    }
    
    /**
     * Method used to retrieve a specific task
     * @param id
     * @return Task
     */
    public Task getTask(long id) {
        return this.dao.getTask(id);
    }

    /**
     * Method used to update a task.
     * @param input - task to update.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto updateTask(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        task.setName(input.getName());
        task.setEstHours(input.getEstHours());
        task.setPhase(input.getPhase());
        task.setCurrentDate(task.getCurrentDate());
        
        task.setSpentHours(task.getSpentHours() + input.getSpentHours());
        task.setFinished(input.isFinished());
        task.setPending(input.isPending());
        task.setToday(input.isToday());
        
        if(task.getSpentHours() <= task.getEstHours() && !this.dao.updateTask(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }

        return input;
    }

    /**
     * Method used to delete a task.
     * @param input - task to delete.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto deleteTask(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        
        if(!this.dao.deleteTask(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }

        return input;
    }
    /**
     * Method used to set a today's task
     * @param input - task to be added to today's tasks.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto addTaskToday(TaskDto input) {
        if(!this.dao.setTodaysTask(input.getId())){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("Add Task Today database error!");
        }

        return input;
    }
    
    /**
     * Method used to finish the task
     * @param input - task to be finished.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto finishTask(TaskDto input) {        
        if(!this.dao.setCompletedTask(input.getId())){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("FINISH TASK database error!");
        }

        return input;
    }
    
    /**
     * Method used to delete a today's task
     * @param input - task to be deleted
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto deleteTaskToday(TaskDto input) {
        if(!this.dao.deleteTodaysTask(input.getId())){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("Delete Task Today database error!");
        }

        return input;
    }
    
    /**
     * Method used to update today's task
     * @param input 
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto updateTaskToday(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        task.setSpentHours(task.getSpentHours() + input.getSpentHours());
        task.setFinished(input.isFinished());
        task.setPending(input.isPending());
        
        if(!this.dao.updateTaskToday(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("Update Task Todaydatabase error!");
        }

        return input;
    }
/**
 * --------------------------------------------------------------------
 * For Tasks Today Controllers
 * --------------------------------------------------------------------
 */
    /**
     * Method used to retrieve list of today's tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getTasksTodayList() {
        List<Task> taskModels = this.dao.getTodaysTasks();
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setCurrentDate(task.getCurrentDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }
    
    /**
     * Method used to retrieve list of pending tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getPendingTasksList() {
        List<Task> taskModels = this.dao.getPendingTasks();
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setCurrentDate(task.getCurrentDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }
    
    /**
     * Method used to retrieve list of finished tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getFinishedTasksList() {
        List<Task> taskModels = this.dao.getFinishedTasks();
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setCurrentDate(task.getCurrentDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }
}
