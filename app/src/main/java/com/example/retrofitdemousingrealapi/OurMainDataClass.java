package com.example.retrofitdemousingrealapi;

import java.util.List;

public class OurMainDataClass {
    private List<ObjectDataClass> data;

    public OurMainDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public OurMainDataClass() {
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
