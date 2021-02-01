package com.example.mytask;

import com.google.gson.annotations.SerializedName;

public class languages {
    @SerializedName("name")
    private String name;

    public languages(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
