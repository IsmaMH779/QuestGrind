package com.example.questgrind.dailyQuest;

public class Quest {
    private int id;
    private String title;
    private Boolean completed;
    private String objective;



    // Declare constructor

    public Quest(int id, String title,  String objective, Boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.objective = objective;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }


    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getObjective() {
        return objective;
    }
}
