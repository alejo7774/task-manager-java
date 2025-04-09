package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private boolean completed;

    public Task(int id, String title, String description, String dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    // ✅ MÉTODOS GETTERS (deben estar dentro de la clase)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " + dueDate + " | " + (completed ? "✅" : "❌");
    }
}
