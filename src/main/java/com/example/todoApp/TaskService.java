package com.example.todoApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private static final Logger logger= LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        List<Task> tasks=taskRepository.findAll();
        logger.info("Retrieved all tasks. Total tasks: {}", tasks.size());
        return tasks;
    }

    public Task getTaskById(Long id) {
        Task task=taskRepository.findById(id).orElse(null);
        if (task != null) {
            logger.info("Retrieved task with id: {} at {}", id, LocalDateTime.now());
        } else {
            logger.warn("Task with id {} not found", id);
        }
        return task;
    }

    public Task saveTask(Task task) {
        Task savedTask=taskRepository.save(task);
        logger.info("Saved task with id: {} and title: {} at {}", savedTask.getId(), savedTask.getTitle(), LocalDateTime.now());
        return savedTask;
    }

    public void deleteTask(Long id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            logger.info("Deleted task with id: {} at {}", id, LocalDateTime.now());
        } else {
            logger.warn("Task with id {} not found for deletion", id);
        }
    }

    public void markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(true);
            taskRepository.save(task);
            logger.info("Marked task with id: {} as completed at {}", id, LocalDateTime.now());
        } else {
            logger.warn("Task with id {} not found for marking as completed", id);
        }
    }

    public void markTaskAsNotCompleted(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setCompleted(false);
            taskRepository.save(task);
            logger.info("Marked task with id: {} as not completed at {}", id, LocalDateTime.now());
        } else {
            logger.warn("Task with id {} not found for marking as not completed", id);
        }
    }
}
