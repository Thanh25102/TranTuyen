package org.trantuyen;

import org.trantuyen.manage.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<Subject> subjects = List.of(
            new Subject(001, "Thiet ke giao dien", null),
            new Subject(002, "Cau truc du lieu va giai thuat", null),
            new Subject(003, "Lap trinh huong doi tuong", null),
            new Subject(004, "Phat trien pham mem ma nguon mo", null)
    );
    public static List<Student> students = new ArrayList<>(List.of(
            new MastersStudent(1L, "Bui Manh Thanh", 25D, LocalDate.of(2002, 10, 25),
                    "2022", Map.of(1, subjects), Map.of(1, 9D), "SGU",
                    LocalDate.of(2022, 10, 25), 3.9F, GraduationType.EXCELLENCE),
            new NormalStudent(2L,"Chau Phu Thinh",29D,LocalDate.of(2002, 10, 26),"2020", Map.of(1, subjects), Map.of(1, 9D)),
            new NormalStudent(3L,"Tran Anh Tuyen",22D,LocalDate.of(2002, 10, 27),"2020", Map.of(1, subjects), Map.of(1, 9D)),
            new OnlineStudent(3L,"Nguyen Huu Bang",23D,LocalDate.of(2002, 10, 28),"2020", Map.of(1, subjects), Map.of(1, 9D),"Ha NOi")
    ));
    public static List<Department> departments2 = List.of(
            new Department("CNTT","Khoa CNTT", students)
    );
    public static void main(String[] args) {
        ConsoleProgram.getInstance().run();
    }
}