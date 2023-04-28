package org.trantuyen.manage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class NormalStudent extends Student{
    public NormalStudent() {
    }

    public NormalStudent(Long id, String fullName, Double score, LocalDate birthday, String yearOfAdmission, Map<Integer, List<Subject>> subjects, Map<Integer, Double> learningOutcomes) {
        super(id, fullName, score, birthday, yearOfAdmission, subjects, learningOutcomes);
    }

    @Override
    public String getTypeStudent() {
        return "sinh viên chính quy";
    }
}
