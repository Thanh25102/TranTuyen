package org.trantuyen;

import org.trantuyen.manage.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleProgram {
    Scanner scanner = new Scanner(System.in);
    private static ConsoleProgram ins;

    private ConsoleProgram() {
    }

    public static ConsoleProgram getInstance() {
        if (ins == null) ins = new ConsoleProgram();
        return ins;
    }

    public void run() {
        menu();
    }

    private void menu() {
        Boolean isExit = false;
        do {
            System.out.println("""
                    ### Chao mung toi voi ung dung qlsv ###
                    Vui long chon chuc nang can thao tac.
                    1. Hiển thị danh sách sinh viên.
                    2. Hiển thị thông tin chi tiết của sinh viên.
                    3. Thêm mới 1 sinh viên.
                    4. Cập nhật dữ liệu 1 sinh viên.
                    5. Nhập dữ liệu từ file txt (sẽ có trong tương lai).
                    6. Thoát chương trình.
                    """);
            int option = scanner.nextInt();
            try {
                switch (option) {
                    case 1:
                        showStudents();
                        break;
                    case 2:
                        showStudent();
                        break;
                    case 3:
                        addStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        importFile();
                        break;
                    case 6:
                        isExit = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println("""
                        ### Da co loi xay ra vui long thuc hien lai thao tac ###định
                        Vui Lòng nhập đúng kiểu dữ liệu quy 
                        """);
                System.out.println("\n");
            }
        } while (!isExit);
    }

    private void showStudents() {
        scanner.nextLine();
        System.out.println("Nhập mã khoa muốn hiển thị danh sách sinh viên (vd: CNTT,...) \n");
        String departmentCode = scanner.nextLine();
        Department departments = Main.departments2.stream()
                .filter(department ->
                        department.getCode().equalsIgnoreCase(departmentCode.trim())
                )
                .findFirst().orElse(null);
        if (departments == null) {
            System.out.println("Không tìm thấy khoa này ...\n");
            return;
        }
        List<Student> students = departments.getStudents();
        System.out.println("### DANH SACH SINH VIEN ###");
        students.forEach(System.out::println);
        System.out.println("### KET THUC ###");
    }

    private void showStudent() {
        System.out.println("Nhập mã sinh viên muốn xem \n");
        Long studentId = scanner.nextLong();
        Student student = Main.students.stream().filter(stu -> stu.getId() == studentId).findFirst().orElse(null);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên này ...");
            return;
        }
        System.out.println("### SINH VIEN ###");
        System.out.println(student.showDetail());
        System.out.println("### KET THUC ###");
    }

    private void addStudent() {
        System.out.println("Thêm mới sinh viên \n");
        scanner.nextLine();
        Department department = null;
        while (department == null) {
            System.out.println("Nhập mã khoa : ");
            String code = scanner.nextLine();
            department = Main.departments2.stream().filter(dpt -> dpt.getCode().equals(code))
                    .findFirst().orElse(null);
            if (department == null) System.out.println("Mã khoa không tồn tại vui lòng nhập lại");
        }
        System.out.println("Nhập mã sinh viên : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Nhập họ và tên : ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh định dạng dd/MM/yyyy : ");
        String birthday = scanner.nextLine();
        System.out.println("Nhập năm nhập học : ");
        String year = scanner.nextLine();
        String[] day = birthday.split("/");
        System.out.println("Nhập điểm đầu vào : ");
        Double score = scanner.nextDouble();
        System.out.println("### Chọn loại sinh viên ###");
        System.out.println("1.Sinh viên chính quy\n2.Học viên tại chức\n3.Học viên cao học");
        int choice = scanner.nextInt();
        Student stu = null;
        switch (choice) {
            case 1:
                stu = new NormalStudent(id, fullName, score, LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0])), year, new HashMap<>(), new HashMap<>());
                break;
            case 2:
                scanner.nextLine();
                System.out.println("Nhập địa chỉ nơi liên kết đào tạo : ");
                String place = scanner.nextLine();
                stu = new OnlineStudent(id, fullName, score, LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0])), year, new HashMap<>(), new HashMap<>(), place);
                break;
            case 3:
                scanner.nextLine();
                System.out.println("Nhập trường đại học đã tốt nghiệp : ");
                String uni = scanner.nextLine();
                System.out.println("Ngày tốt nghiệp dạng (dd/MM/yyyy) : ");
                String graduationDate = scanner.nextLine();
                String[] graduationDates = graduationDate.split("/");
                System.out.println("Mã văn bằng : ");
                Float diplomaId = scanner.nextFloat();
                System.out.println("### Chọn loại tốt nghiệp ###");
                System.out.println("1.Xuất sắc\n2.Giỏi\n3.Khá\n4.Trung bình");
                int choiceType = scanner.nextInt();
                GraduationType type = null;
                switch (choiceType) {
                    case 1:
                        type = GraduationType.EXCELLENCE;
                        break;
                    case 2:
                        type = GraduationType.HONORS;
                        break;
                    case 3:
                        type = GraduationType.PRETTY_GOOD;
                        break;
                    case 4:
                        type = GraduationType.AVERAGE;
                        break;
                    default:
                        break;
                }
                stu = new MastersStudent(id, fullName, score, LocalDate.of(Integer.parseInt(day[2]), Integer.parseInt(day[1]), Integer.parseInt(day[0])), year,
                        new HashMap<>(), new HashMap<>(), uni, LocalDate.of(Integer.parseInt(graduationDates[2]), Integer.parseInt(graduationDates[1]), Integer.parseInt(graduationDates[0])),
                        diplomaId, type
                );
                break;
            default:
                break;
        }
        Main.students.add(stu);
    }

    private void updateStudent() {
        System.out.println("Cập nhật thông tin sinh viên \n");
        System.out.println("Nhập mã sinh viên cần cập nhật : ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        Student student = Main.students.stream().filter(stu -> stu.getId() == studentId).findFirst().orElse(null);
        if (student == null) {
            System.out.println("Không tìm thấy sinh viên này ... ");
            return;
        }
        System.out.println("Nhập họ và tên : ");
        String fullName = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh định dạng dd/MM/yyyy : ");
        String birthDay = scanner.nextLine();
        System.out.println("Nhập điểm đầu vào : ");
        String score = scanner.nextLine();
        System.out.println("Nhập năm nhập học : ");
        String year = scanner.nextLine();

        if (!fullName.trim().equalsIgnoreCase("boqua")) student.setFullName(fullName);
        if (!birthDay.trim().equalsIgnoreCase("boqua")) {
            String[] date = birthDay.split("/");
            LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
            student.setBirthday(localDate);
        }
        if (!score.trim().equalsIgnoreCase("boqua")) student.setScore(Double.parseDouble(score));
        if (!year.trim().equalsIgnoreCase("boqua")) student.setYearOfAdmission(year);

        System.out.println(student);
        Main.students = Main.students.stream().map(stu -> stu.getId() == student.getId() ? student : stu).collect(Collectors.toList());
    }

    private void importFile() {
        System.out.println("Chức năng nhập dữ liệu từ file sẽ được bổ sung trong tương ");
    }

}
