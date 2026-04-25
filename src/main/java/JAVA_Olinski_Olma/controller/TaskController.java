package JAVA_Olinski_Olma.controller;

import JAVA_Olinski_Olma.model.Task;
import JAVA_Olinski_Olma.repository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Tasks", description = "Operations on tasks")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Operation(summary = "Retrieve all tasks")
    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Operation(summary = "Create a new task")
    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }
}