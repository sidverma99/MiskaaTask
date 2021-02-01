package com.example.mytask;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("name")
    private String name;
    @SerializedName("capital")
    private String capital;
    @SerializedName("region")
    private String region;
    @SerializedName("subregion")
    private String subRegion;
    @SerializedName("population")
    private Long population;
    @SerializedName("flag")
    private String flag;
    @SerializedName("borders")
    private List<String> borders;
    @SerializedName("languages")
    private List<languages> languagesList;

    public Response(String name, String capital, String region, String subRegion, Long population, String flag, List<String> borders, List<languages> languagesList) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.subRegion = subRegion;
        this.population = population;
        this.flag = flag;
        this.borders = borders;
        this.languagesList = languagesList;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public Long getPopulation() {
        return population;
    }

    public String getFlag() {
        return flag;
    }

    public List<String> getBorders() {
        return borders;
    }

    public List<languages> getLanguagesList() {
        return languagesList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public void setLanguagesList(List<languages> languagesList) {
        this.languagesList = languagesList;
    }
}
