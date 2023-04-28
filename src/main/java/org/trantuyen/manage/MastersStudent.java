package org.trantuyen.manage;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class MastersStudent extends Student {
    private String almaMaster;
    private LocalDate graduationDate;
    private Float diplomaId;
    private GraduationType graduationType;

    public MastersStudent() {
    }

    public MastersStudent(Long id, String fullName, Double score, LocalDate birthday, String yearOfAdmission, Map<Integer, List<Subject>> subjects, Map<Integer, Double> learningOutcomes, String almaMaster, LocalDate graduationDate, Float diplomaId, GraduationType graduationType) {
        super(id, fullName, score, birthday, yearOfAdmission, subjects, learningOutcomes);
        this.almaMaster = almaMaster;
        this.graduationDate = graduationDate;
        this.diplomaId = diplomaId;
        this.graduationType = graduationType;
    }

    @Override
    public String getTypeStudent() {
        return "học viên cao học";
    }

    public String getAlmaMaster() {
        return almaMaster;
    }

    public void setAlmaMaster(String almaMaster) {
        this.almaMaster = almaMaster;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Float getDiplomaId() {
        return diplomaId;
    }

    public void setDiplomaId(Float diplomaId) {
        this.diplomaId = diplomaId;
    }

    public GraduationType getGraduationType() {
        return graduationType;
    }

    public void setGraduationType(GraduationType graduationType) {
        this.graduationType = graduationType;
    }

    public String getLmaMater() {
        return almaMaster;
    }

    public void setLmaMater(String almaMaster) {
        this.almaMaster = almaMaster;
    }
}
