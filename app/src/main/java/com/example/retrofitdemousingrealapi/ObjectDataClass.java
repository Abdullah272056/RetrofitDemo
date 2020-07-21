package com.example.retrofitdemousingrealapi;

public class ObjectDataClass {
    private  String resource;
    private int id;
    private String name;
    private String updated_at;

    public ObjectDataClass(String resource, int id, String name, String updated_at) {
        this.resource = resource;
        this.id = id;
        this.name = name;
        this.updated_at = updated_at;
    }

    public ObjectDataClass() {
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
