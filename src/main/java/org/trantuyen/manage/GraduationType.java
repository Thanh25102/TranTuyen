package org.trantuyen.manage;

public enum GraduationType {
    HONORS("giỏi"), EXCELLENCE("xuất sắc"), PRETTY_GOOD("khá"), AVERAGE("trung bình");
    private String value;

    GraduationType(String type) {
        this.value = type;
    }

}
