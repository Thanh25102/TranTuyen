package org.trantuyen.manage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OnlineStudent extends Student {
    private String place;

    public OnlineStudent() {
    }

    public OnlineStudent(Long id, String fullName, Double score, LocalDate birthday, String yearOfAdmission, Map<Integer, List<Subject>> subjects, Map<Integer, Double> learningOutcomes, String place) {
        super(id, fullName, score, birthday, yearOfAdmission, subjects, learningOutcomes);
        this.place = place;
    }

    @Override
    public String getTypeStudent() {
        return "sinh viên tại chức";
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
