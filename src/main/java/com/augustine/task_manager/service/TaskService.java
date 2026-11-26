package com.augustine.task_manager.service;

import com.augustine.task_manager.dtos.CreateTaskRequest;
import com.augustine.task_manager.dtos.TaskResponse;
import com.augustine.task_manager.entity.Task;
import com.augustine.task_manager.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponse createTask(CreateTaskRequest request){
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .completed(false)
                .build();

        Task savedTask = taskRepository.save(task);
        return createTaskResponse(savedTask);
    }

    private TaskResponse createTaskResponse(Task task){
        TaskResponse taskResponse = TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .completed(task.isCompleted())
                .build();
        return  taskResponse;
    }
}
