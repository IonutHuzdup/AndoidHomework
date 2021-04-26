package com.example.secondhomework.models;

public class Job {
    private String id;
    private String companyId;
    private String createdAt;
    private String name;
    private String description;

    public Job(String id, String companyId, String createdAt, String name, String description) {
        this.id = id;
        this.companyId = companyId;
        this.createdAt = createdAt;
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
