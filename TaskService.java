// Import HashMap so we can store tasks in memory using key-value pairs.
import java.util.HashMap;

// Import Map so the tasks collection can be declared using the Map interface.
import java.util.Map;

public class TaskService {

    // Stores all Task objects in memory.
    // The String key is the task ID, and the Task value is the actual task object.
    private final Map<String, Task> tasks;

    // Constructor creates a new empty HashMap when the service is created.
    public TaskService() {
        tasks = new HashMap<>();
    }

    // Adds a new task to the service.
    public void addTask(Task task) {

        // A null task should not be added because it would not meet the requirements.
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }

        // Checks whether a task with the same ID already exists.
        // Task IDs must be unique.
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique.");
        }

        // Adds the task to the HashMap using the task ID as the key.
        tasks.put(task.getTaskId(), task);
    }

    // Deletes a task based on its task ID.
    public void deleteTask(String taskId) {

        // If the task ID is not found, throw an exception.
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found.");
        }

        // Removes the task from the HashMap.
        tasks.remove(taskId);
    }

    // Updates the name field for an existing task.
    public void updateTaskName(String taskId, String name) {

        // If the task ID is not found, throw an exception.
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found.");
        }

        // Uses the Task class setter so name validation still happens.
        tasks.get(taskId).setName(name);
    }

    // Updates the description field for an existing task.
    public void updateTaskDescription(String taskId, String description) {

        // If the task ID is not found, throw an exception.
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task ID was not found.");
        }

        // Uses the Task class setter so description validation still happens.
        tasks.get(taskId).setDescription(description);
    }

    // Returns a task by its task ID.
    // If the task does not exist, this returns null.
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}