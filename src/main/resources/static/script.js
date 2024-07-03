document.addEventListener("DOMContentLoaded", function() {
    let tasks = document.querySelectorAll(".task");
    let currentDate = new Date();
    
    tasks.forEach(task => {
        let dueDate = new Date(task.dataset.dueDate);
        if (dueDate <= currentDate) {
            alert(`Task "${task.dataset.title}" is due!`);
        }
    });
});
