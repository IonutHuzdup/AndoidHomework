package com.example.secondhomework.models;

public class Portofolio {
    private String id;
    private String createdAt;
    private String avatar;

    public Portofolio(String id, String createdAt, String avatar) {
        this.id = id;
        this.createdAt = createdAt;
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getAvatar() {
        return avatar;
    }
}
