import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonCreateTest {
    List<Person> personList = new ArrayList<>();

    @Test
    public void testPersonAndTaskCreation() {
        String personName = "TestName";
        final List<Task> tasks = List.of(new Task("Task 1", false));
        Person person = new Person(personName, tasks);

        personList.add(person);

        assertEquals(person.getName(), personName);
        assertEquals(person.getTasks(), tasks);
    }

}
