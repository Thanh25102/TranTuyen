package org.trantuyen.manage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public abstract class Student {
    private Long id;
    private String fullName;
    private LocalDate birthday;
    private String yearOfAdmission;

    private Double score;

    private Map<Integer, List<Subject>> subjects;
    private Map<Integer, Double> learningOutcomes;

    public Student() {
    }

    public Double getAvgScoreOfSemester(Integer semester) {
        Double avgOfSemester = getSubjects().get(semester).stream()
                .mapToDouble(Subject::getAvgScore)
                .average().getAsDouble();
        learningOutcomes.put(semester, avgOfSemester);
        return avgOfSemester;
    }

    public abstract String getTypeStudent();

    public Student(Long id, String fullName, Double score, LocalDate birthday, String yearOfAdmission, Map<Integer, List<Subject>> subjects, Map<Integer, Double> learningOutcomes) {
        this.id = id;
        this.fullName = fullName;
        this.score = score;
        this.birthday = birthday;
        this.yearOfAdmission = yearOfAdmission;
        this.subjects = subjects;
        this.learningOutcomes = learningOutcomes;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getYearOfAdmission() {
        return yearOfAdmission;
    }

    public void setYearOfAdmission(String yearOfAdmission) {
        this.yearOfAdmission = yearOfAdmission;
    }

    public Map<Integer, List<Subject>> getSubjects() {
        return subjects;
    }

    public void setSubjects(Map<Integer, List<Subject>> subjects) {
        this.subjects = subjects;
    }

    public Map<Integer, Double> getLearningOutcomes() {
        return learningOutcomes;
    }

    public void setLearningOutcomes(Map<Integer, Double> learningOutcomes) {
        this.learningOutcomes = learningOutcomes;
    }

    @Override
    public String toString() {
        return "Sinh viên{" +
                "Mã sinh viên=" + id +
                ", Tên đầy đủ='" + fullName + "'}";
    }

    public String showDetail() {
        return "Mã = " + id +
                ", Tên đầy đủ = '" + fullName + '\'' +
                ", Ngày sinh = " + birthday +
                ", Năm vào học = '" + yearOfAdmission + '\'' +
                ", Điểm đầu vào = " + score;
    }
}
