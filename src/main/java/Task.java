public final class Task {

    private String name;
    private Boolean isStarted;

    Task(String name, Boolean isStarted) {
        this.name = name;
        this.isStarted = isStarted;
    }

    public String getName() {
        return name;
    }

    public Boolean getStarted() {
        return isStarted;
    }

    public void setStarted(Boolean started) {
        isStarted = started;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", isStarted=" + isStarted +
                '}';
    }
}
