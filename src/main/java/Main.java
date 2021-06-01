import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static List<Person> persons = new ArrayList<>();
    private static int kmToRun = 5;

    public static void main(String... args) {
        String firstPersonName = "Gicu";
        String secondPersonName = "Ana";

        String taskName = "Run";

        create(firstPersonName, taskName);
        create(secondPersonName, taskName);

        start(firstPersonName, taskName + " " + (kmToRun -1) + " km");
        stop(firstPersonName, taskName);

        final List<Task> list = list(firstPersonName);
        list.forEach(System.out::println);
    }

    private static void create(String personName, String taskName) {

        final boolean isUserPresent = persons.stream()
                .anyMatch(person -> person.getName().equals(personName));

        if (!isUserPresent) {
            persons.add(new Person(personName, List.of(
                    new Task(taskName + " " + kmToRun++ + " km", false),
                    new Task(taskName + " " + kmToRun + " km", false))));
        } else
            System.out.println("User is created with such name already");
    }

    private static void start(String personName, String taskName) {
        setUserTaskStatus(personName, taskName, true);
    }

    private static void stop(String personName, String taskName) {
        setUserTaskStatus(personName, taskName, false);
    }

    private static List<Task> list(String personName) {
        return persons.stream()
                .filter(person -> person.getName().equals(personName))
                .map(Person::getTasks)
                .collect(Collectors.toUnmodifiableList())
                .get(0);
    }

    private static void setUserTaskStatus(String personName, String taskName, Boolean taskStatus) {
        for (Person person : persons) {
            if (person.getName().equals(personName)) {
                for(Task task : person.getTasks()) {
                    if (task.getName().equals(taskName)){
                        try {
                            person.getClass()
                                    .getDeclaredField("tasks");
                            task.setStarted(taskStatus);
                        } catch (NoSuchFieldException e) {
                            System.out.println("exception");
                        }
                    }
                }
            }
        }
    }


}
