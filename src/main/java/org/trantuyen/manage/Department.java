package org.trantuyen.manage;

import java.util.Comparator;
import java.util.List;

public class Department {
    private String code;
    private String name;
    private List<Student> students;

    public Department() {
    }

    public Department(String code,String name, List<Student> students) {
        this.code = code;
        this.name = name;
        this.students = students;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student highestScoreOfDepartment(){
        return students.stream()
                .max(Comparator.comparing(Student::getScore))
                .orElse(null);
    }

    @Override
    public String toString() {
        return "Department{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
