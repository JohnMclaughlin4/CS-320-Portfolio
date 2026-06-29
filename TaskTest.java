import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TaskTest {

    // Tests that a task can be created successfully with valid values.
    @Test
    public void testTaskCreatedSuccessfully() {
        Task task = new Task("TASK123", "Pay Bills", "Pay electric and water bills");

        // Checks that each field was stored correctly.
        assertEquals("TASK123", task.getTaskId());
        assertEquals("Pay Bills", task.getName());
        assertEquals("Pay electric and water bills", task.getDescription());
    }

    // Tests that the task ID cannot be null.
    @Test
    public void testTaskIdCannotBeNull() {

        // A null task ID should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Pay Bills", "Pay electric and water bills");
        });
    }

    // Tests that the task ID cannot be longer than 10 characters.
    @Test
    public void testTaskIdCannotBeLongerThanTenCharacters() {

        // This task ID has more than 10 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK1234567", "Pay Bills", "Pay electric and water bills");
        });
    }

    // Tests that the name cannot be null.
    @Test
    public void testNameCannotBeNull() {

        // A null name should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK123", null, "Pay electric and water bills");
        });
    }

    // Tests that the name cannot be longer than 20 characters.
    @Test
    public void testNameCannotBeLongerThanTwentyCharacters() {

        // This name has more than 20 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK123", "This name is too long", "Pay electric and water bills");
        });
    }

    // Tests that the description can no be null.
    @Test
    public void testDescriptionCannotBeNull() {

        // A null description should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK123", "Pay Bills", null);
        });
    }

    // Tests that the description cannot be longer than 50 characters.
    @Test
    public void testDescriptionCannotBeLongerThanFiftyCharacters() {

        // This description has more than 50 characters, so it should throw an exception.
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("TASK123", "Pay Bills", "This description is definitely longer than fifty characters total.");
        });
    }

    // Tests that the task name can be updated.
    @Test
    public void testNameCanBeUpdated() {
        Task task = new Task("TASK123", "Pay Bills", "Pay electric and water bills");

        // Update the task name.
        task.setName("Buy Food");

        // Check that the name changed.
        assertEquals("Buy Food", task.getName());
    }

    // Tests that the task description can be updated.
    @Test
    public void testDescriptionCanBeUpdated() {
        Task task = new Task("TASK123", "Pay Bills", "Pay electric and water bills");

        // Update the task description.
        task.setDescription("Buy groceries for dinner");

        // Check that the description changed.
        assertEquals("Buy groceries for dinner", task.getDescription());
    }
}