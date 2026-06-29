public class Task {

    // The task ID is final because it should not be updated after the task is created.
    private final String taskId;

    // The task name can be updated, so it is not final.
    private String name;

    // The task description can also be updated, so it is not final.
    private String description;

    // Constructor used to create a new Task object.
    public Task(String taskId, String name, String description) {

        // Validate all fields before assigning them.
        validateTaskId(taskId);
        validateName(name);
        validateDescription(description);

        // Assign values only after they pass validation.
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    // Returns the task ID.
    public String getTaskId() {
        return taskId;
    }

    // Returns the task name.
    public String getName() {
        return name;
    }

    // Returns the task description.
    public String getDescription() {
        return description;
    }

    // Updates the task name after validating it.
    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    // Updates the task description after validating it.
    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // Checks that the task ID is not null and is not longer than 10 characters.
    private void validateTaskId(String taskId) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null or longer than 10 characters.");
        }
    }

    // Checks that the name is not null and is not longer than 20 characters.
    private void validateName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null or longer than 20 characters.");
        }
    }

    // Checks that the description is not null and is not longer than 50 characters.
    private void validateDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null or longer than 50 characters.");
        }
    }
}