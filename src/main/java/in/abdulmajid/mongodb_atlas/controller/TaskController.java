package in.abdulmajid.mongodb_atlas.controller;

import in.abdulmajid.mongodb_atlas.model.Task;
import in.abdulmajid.mongodb_atlas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task createTask(@RequestBody Task task)
    {
        return taskService.addTask(task);
    }
    @GetMapping("/{taskId}")
    public Task getttTask(@PathVariable String taskId)
    {
        return taskService.getTaskById(taskId);
    }
    @GetMapping
    public List<Task> getAllTasks()
    {
        return taskService.findAllTasks();
    }
    @GetMapping("/severity/{severity}")
    public List<Task> findTaskBySeverity(@PathVariable Integer severity)
    {
        return taskService.getTaskBySeverity(severity);
    }
    @GetMapping("/assignee/{assignee}")
    public List<Task> findTaskByAssignee(@PathVariable String assignee)
    {
        return taskService.getTaskByAssignee(assignee);
    }
    @PutMapping
    public Task modifyTask(@RequestBody Task taskRequest)
    {
        return taskService.updateTask(taskRequest);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId)
    {
       return taskService.deleteTask(taskId);

    }



}
