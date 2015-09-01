package taskmanagement.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    TaskDao dao = new TaskDao();
    
    
    /**
     * Method used to add a task.
     * @param input - taskDto to add.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto addTask(TaskDto input) {
        Task task = new Task();
        
        task.setId(input.getId());
        task.setUserId(input.getUserId());
        task.setName(input.getName());
        task.setPhase(input.getPhase());
        task.setEstHours(input.getEstHours());
        task.setStartDate(input.getStartDate());
        task.setDueDate(input.getDueDate());
        task.setSpentHours(input.getSpentHours());
        task.setFinished(input.isFinished());
        task.setPending(input.isPending());
        task.setToday(input.isToday());
        
        if(!this.dao.saveTask(task)) {
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }
        return input;
    }

    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getTaskList() {
        List<Task> taskModels = this.dao.getAllTasks();
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
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
     * Method used to check list of unfinished tasks.
     * @return void
     */
    public void checkTodaysTask() {
        List<Task> taskModels = this.dao.getAllTasks();
        TaskClientDto taskList = new TaskClientDto();
        Date today = new Date();
        today = this.trim(today);
        for (Task task : taskModels) {      
            Date start = null;
            Date due = null;
            DateFormat df = new SimpleDateFormat("dd MMMM, yyyy"); 
            //System.out.println("TODAY: " + today.toString());
            try {
                start = df.parse(task.getStartDate());
                //System.out.println("START: " + start.toString());
                due = df.parse(task.getDueDate());
                //System.out.println("DUE: " + due.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //System.out.println("CONDITION: " +(today.equals(start) && today.equals(due) || (today.after(start) && today.before(due))));
            if((today.equals(start) && today.equals(due) || (today.after(start) && today.before(due))) && !this.dao.setTodaysTask(task.getId())){
                taskList.setErrorList(new ArrayList<String>());
                taskList.getErrorList().add("Todays Task: database error!");
            }
        }
    }
    /**
     * Method used to retrieve list of todays tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto getTodaysTaskList() {
        List<Task> taskModels = this.dao.getAllTasks();
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;
        checkTodaysTask();

        for (Task task : taskModels) {
            if(task.isToday()){
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
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
     * Method used to retrieve a task.
     * @return Task
     */
    public TaskDto selectTask(TaskDto input) {
        Task taskModel = new Task();
        taskModel = this.dao.selectTask(input.getId());
        input.setUserId(taskModel.getUserId());
        input.setName(taskModel.getName());
        input.setPhase(taskModel.getPhase());
        input.setEstHours(taskModel.getEstHours());
        input.setStartDate(taskModel.getStartDate());
        input.setDueDate(taskModel.getDueDate());
        input.setSpentHours(taskModel.getSpentHours());
        input.setFinished(taskModel.isFinished());
        input.setPending(taskModel.isPending());
        input.setToday(taskModel.isToday());
        return input;
    }
        
    /**
     * Method used to retrieve list of tasks.
     * @return List<Task> - list of Tasks.
     */
    public TaskClientDto searchTasks(String name) {
        List<Task> taskModels = this.dao.searchTasks(name);
        TaskClientDto taskList = new TaskClientDto();
        TaskDto taskDto;

        for (Task task : taskModels) {
            taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setUserId(task.getUserId());
            taskDto.setName(task.getName());
            taskDto.setPhase(task.getPhase());
            taskDto.setEstHours(task.getEstHours());
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }

    /**
     * Method used to update a task.
     * @param input - task to update.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto updateTask(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        //task.setCreatedDate(Calendar.getInstance().getTime().toString());
        task.setName(input.getName());
        task.setEstHours(input.getEstHours());
        task.setPhase(input.getPhase());
        task.setStartDate(input.getStartDate());
        task.setDueDate(input.getDueDate());
        task.setSpentHours(task.getSpentHours() + input.getSpentHours());
        task.setFinished(input.isFinished());
        task.setPending(input.isPending());
        task.setToday(input.isToday());
        
        if(!this.dao.updateTask(task)){
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
     * @param input - task to delete.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto addTaskToday(TaskDto input) {
        Task task = new Task();
        task.setId(input.getId());
        task.setToday(input.isToday());
        
        if(!this.dao.updateTask(task)){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("database error!");
        }

        return input;
    }
    
    /**
     * Method used to finish the task
     * @param input - task to be finished.
     * @return TaskDto - if transaction was unsuccessful, contains list of errors.
     */
    public TaskDto finishTask(TaskDto input) {
        Task task = new Task();
        TaskDto selectedTask = selectTask(input);
        task.setFinished(true);
        task.setName(selectedTask.getName());
        task.setEstHours(selectedTask.getEstHours());
        task.setPhase(selectedTask.getPhase());
        task.setStartDate(selectedTask.getStartDate());
        task.setDueDate(selectedTask.getDueDate());
        task.setSpentHours(selectedTask.getSpentHours());
        task.setToday(selectedTask.isToday());
        task.setPending(selectedTask.isPending());
        
        if(!this.dao.setCompletedTask(input.getId())){
            input.setErrorList(new ArrayList<String>());
            input.getErrorList().add("FINISH TASK database error!");
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
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
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
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
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
            taskDto.setStartDate(task.getStartDate());
            taskDto.setDueDate(task.getDueDate());
            taskDto.setSpentHours(task.getSpentHours());
            taskDto.setFinished(task.isFinished());
            taskDto.setPending(task.isPending());
            taskDto.setToday(task.isToday());
            taskList.getTaskList().add(taskDto);
        }

        return taskList;
    }
}
