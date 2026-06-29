import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    // TaskService object for each test.
    private TaskService taskService;

    // Task object used as a sample task in each test.
    private Task task;

    // Runs before each test method.
    // This gives every test a fresh TaskService and Task object.
    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
        task = new Task("TASK123", "Pay Bills", "Pay electric and water bills");
    }

    // Tests that a task can be added successfully.
    @Test
    public void testAddTaskSuccessfully() {
        taskService.addTask(task);

        // Checks that the task was actually added.
        assertNotNull(taskService.getTask("TASK123"));

        // Checks that the stored task has the correct task ID.
        assertEquals("TASK123", taskService.getTask("TASK123").getTaskId());
    }

    // Tests that a null task cannot be added.
    @Test
    public void testCannotAddNullTask() {

        // Adding null should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(null);
        });
    }

    // Tests that two tasks cannot have the same task ID.
    @Test
    public void testCannotAddDuplicateTaskId() {
        Task duplicateTask = new Task("TASK123", "Buy Food", "Buy groceries for dinner");

        // Add the TAsk first.
        taskService.addTask(task);

        // Adding another task with the same ID should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(duplicateTask);
        });
    }

    // Tests that a task can be delted successfully.
    @Test
    public void testDeleteTaskSuccessfully() {
        taskService.addTask(task);
        taskService.deleteTask("TASK123");

        // After deleting, the task should no longer exist.
        assertNull(taskService.getTask("TASK123"));
    }

    // Tests that deleting a task with an invalid ID throws an exception.
    @Test
    public void testDeleteTaskWithInvalidIdThrowsException() {

        // BADID does not exist, so this should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.deleteTask("BADID");
        });
    }

    // Tests that a task name can be updated successfully.
    @Test
    public void testUpdateTaskNameSuccessfully() {
        taskService.addTask(task);
        taskService.updateTaskName("TASK123", "Buy Food");

        // Checks that the task name was updated.
        assertEquals("Buy Food", taskService.getTask("TASK123").getName());
    }

    // Tests that a task description can be updated successfully.
    @Test
    public void testUpdateTaskDescriptionSuccessfully() {
        taskService.addTask(task);
        taskService.updateTaskDescription("TASK123", "Buy groceries for dinner");

        // Checks that the task description was updated.
        assertEquals("Buy groceries for dinner", taskService.getTask("TASK123").getDescription());
    }

    // Tests that updating a name with an invalid task ID throws an exception.
    @Test
    public void testUpdateNameWithInvalidIdThrowsException() {

        // BADID does not exists, so this should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("BADID", "Buy Food");
        });
    }

    // Tests that updating a description with an invalid task ID throws an exception.
    @Test
    public void testUpdateDescriptionWithInvalidIdThrowsException() {

        // BADID does not exist, so this should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("BADID", "Buy groceries for dinner");
        });
    }

    // Tests that the task name cannot be updated to an invalid value.
    @Test
    public void testUpdateNameWithInvalidNameThrowsException() {
        taskService.addTask(task);

        // The name is longer than 20 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskName("TASK123", "This name is too long");
        });
    }

    // Tests that the task description cannot be updated to an invalid value.
    @Test
    public void testUpdateDescriptionWithInvalidDescriptionThrowsException() {
        taskService.addTask(task);

        // The description is longer than 50 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.updateTaskDescription("TASK123", "This description is definitely longer than fifty characters total.");
        });
    }
}