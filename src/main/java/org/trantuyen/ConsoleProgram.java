package org.trantuyen;

import org.trantuyen.manage.Department;
import org.trantuyen.manage.NormalStudent;
import org.trantuyen.manage.OnlineStudent;
import org.trantuyen.manage.Student;

import java.util.List;
import java.util.Scanner;

public class ConsoleProgram {
    Scanner scanner = new Scanner(System.in);

    public ConsoleProgram() {
    }

    private void menu(Integer option) {
        Boolean isExit = false;
        System.out.println("### Chao mung toi voi ung dung qlsv ###");
        do {
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
                isExit = true;
                System.out.println("### Da co loi xay ra vui long thuc hien lai thao tac ###");
                System.out.println("\n");
            }
        } while (!isExit);
    }

    private void showStudents() {
        System.out.println("Nhập mã khoa muốn hiển thị danh sách sinh viên \n");
        String departmentCode = scanner.nextLine();
        List<Student> students = Main.departments.stream()
                .filter(department -> department.getName().equals(departmentCode))
                .findFirst().orElse(null).getStudents();
        System.out.println("### DANH SACH SINH VIEN ###");
        students.forEach(System.out::println);
        System.out.println("### KET THUC ###");
    }

    private void showStudent() {
        System.out.println("Nhập mã sinh viên muốn xem \n");
        Long studentId = scanner.nextLong();
        Student student = Main.students.stream().filter(stu->stu.getId() == studentId).findFirst().orElse(null);
        System.out.println("### SINH VIEN ###");
        System.out.println(student);
        System.out.println("### KET THUC ###");
    }

    private void addStudent() {
        System.out.println("Thêm mới sinh viên \n");

        Department department = null;
        while (department == null){
            System.out.println("Nhập mã khoa : ");
            String code = scanner.nextLine();
            department = Main.departments.stream().filter(dpt -> dpt.getCode().equals(code))
                    .findFirst().orElse(null);
            if(department == null) System.out.println("Mã khoa không tồn tại vui lòng nhập lại");
        }
        System.out.println("Nhập họ và tên : ");
        System.out.println("Nhập ngày tháng năm sinh định dạng dd/MM/yyyy : ");
        System.out.println("Nhập điểm đầu vào : ");
        System.out.println("### Chọn loại sinh viên ###");
        System.out.println("1. Sinh viên chính quy\n2.Học viên tại chức\n3.Học viên cao học");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 :
                new NormalStudent();
                break;
            case 2 :
                System.out.println("Nhập địa chỉ nơi liên kết đào tạo : ");
                new OnlineStudent();
            case 3 :
                System.out.println("Nhập trường đại học đã tốt nghiệp : ");
                System.out.println("Ngày tốt nghiệp : ");
                System.out.println("Mã văn bằng : ");
                System.out.println("### Chọn loại tốt nghiệp ###");
                System.out.println("1.Xuất sắc\n2.\n3.Khá\n4.Trung bình");
                int choiceType = scanner.nextInt();
                switch (choiceType){
                    case 1 :break;
                    case 2 :break;
                    case 3 :break;
                    case 4 :break;
                    default: break;
                }

        }

    }

    private void updateStudent() {
        System.out.println("Cập nhật thông tin sinh viên \n");
        System.out.println("Nhập mã sinh viên cần cập nhật");
        int studentId = scanner.nextInt();
        Student student = Main.students.stream().filter(stu -> stu.getId()==studentId).findFirst().orElse(null);
        if(student == null){
            System.out.println("Không tìm thấy sinh viên này ... ");
            return;
        }

    }

    private void importFile() {
    }

}
