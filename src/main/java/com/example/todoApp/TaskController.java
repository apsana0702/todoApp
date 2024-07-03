package com.example.todoApp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/security")
    public String getMessage(){
        return "redirect:/tasks/";
    }


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @GetMapping("/")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "task-list";
    }

    @PostMapping("/create")
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }
    @PostMapping("/complete/{id}")
    public String markTaskAsCompleted(@PathVariable Long id) {
        taskService.markTaskAsCompleted(id);
        return "redirect:/tasks/";
    }

    @PostMapping("/uncomplete/{id}")
    public String markTaskAsNotCompleted(@PathVariable Long id) {
        taskService.markTaskAsNotCompleted(id);
        return "redirect:/tasks/";
    }


}
