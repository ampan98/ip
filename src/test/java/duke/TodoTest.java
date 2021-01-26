package duke;

import main.java.duke.Todo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Used to test Todo, a subclass of Task.
 */
public class TodoTest {
    @Test
    public void testName() {
        Todo task = new Todo("borrow books");
        assertEquals("[T][ ] borrow books", task.toString());
    }

    @Test
    public void testMarkAsDone() {
        Todo task = new Todo("borrow books");
        task.markAsDone();
        assertEquals("[T][X] borrow books", task.toString());
    }
}
