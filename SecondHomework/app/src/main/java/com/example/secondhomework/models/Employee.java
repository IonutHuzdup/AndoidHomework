package com.example.secondhomework.models;

public class Employee {
    private String id;
    private String jobId;
    private String createdAt;
    private String name;
    private String avatar;
    private String phone;

    public Employee(String id, String jobId, String createdAt, String name, String avatar, String phone) {
        this.id = id;
        this.jobId = jobId;
        this.createdAt = createdAt;
        this.name = name;
        this.avatar = avatar;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getJobId() {
        return jobId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPhone() {
        return phone;
    }
}
