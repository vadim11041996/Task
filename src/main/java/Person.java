import java.util.List;

public final class Person {

    private String name;
    private List<Task> tasks;

    Person(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
