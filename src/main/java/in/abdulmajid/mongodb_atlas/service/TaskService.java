package in.abdulmajid.mongodb_atlas.service;

import in.abdulmajid.mongodb_atlas.model.Task;
import in.abdulmajid.mongodb_atlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    // CRUD CREATE,READ ,UPDATE ,DELETE

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("_")[0]);
        return repository.save(task);
    }

    public Task getTaskById(String taskId)
    {
       return repository.findById(taskId).get();
    }

    public List<Task> findAllTasks()
    {
        return repository.findAll();
    }

    public List<Task> getTaskBySeverity(int severity)
    {
             return repository.findTaskBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee)
    {
        return repository.getTasksByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest)
    {
        //get the existing document from db
        Task existingTask=repository.findById(taskRequest.getTaskId()).get();
        //populate new value from request to existing object/entity/document

        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return repository.save(existingTask);

        //if there is large field which need update then I can create wrapper or something, here little data that's why I use this method

    }

    public String deleteTask(String taskId)
    {
        repository.deleteById(taskId);
        return taskId + " Task Deleted Successfully from dashboard";
    }


}
