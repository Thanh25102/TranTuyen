package org.trantuyen.manage;

public class Subject {
    private Integer id;
    private String name;
    private Float avgScore;

    public Subject() {
    }

    public Subject(Integer id, String name, Float avgScore) {
        this.id = id;
        this.name = name;
        this.avgScore = avgScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Float avgScore) {
        this.avgScore = avgScore;
    }
}
