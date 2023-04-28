package org.trantuyen;

import org.trantuyen.manage.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Subject> subjects = List.of(
            new Subject(001, "Thiet ke giao dien", null),
            new Subject(002, "Cau truc du lieu va giai thuat", null),
            new Subject(003, "Lap trinh huong doi tuong", null),
            new Subject(004, "Phat trien pham mem ma nguon mo", null)
    );
    public static List<Student> students = List.of(
            new MastersStudent(1L, "Bui Manh Thanh", 25, LocalDate.of(2002, 10, 25),
                    "2022", Map.of(1, subjects), Map.of(1, 9D), "SGU",
                    LocalDate.of(2022, 10, 25), 3.9F, GraduationType.EXCELLENCE));
    public static List<Department> departments = List.of(
            new Department("CNTT","Khoa CNTT", students)
    );

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}