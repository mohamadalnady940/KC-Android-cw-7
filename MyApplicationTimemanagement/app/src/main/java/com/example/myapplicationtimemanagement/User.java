package com.example.myapplicationtimemanagement;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private String task;
    private String time;
    private String discription;

    public User() {
    }

    public User(String task, String time, String discription) {
        this.task = task;
        this.time = time;
        this.discription = discription;
    }

    public String getTask() {
        return task;
    }

    public String getTime() {
        return time;
    }

    public String getDiscription() {
        return discription;
    }
}
