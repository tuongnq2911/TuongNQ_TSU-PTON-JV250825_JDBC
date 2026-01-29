package Exer02.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;
    private static Set<String> existingIds = new HashSet<>();

    public Appointment() {
    }

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public void inputData(Scanner scanner, Set<String> currentIds) {
        while (true) {
            System.out.println("Mời bạn nhâp vào mã lịch hẹn gồm 6 ký tự không trùng lặp: ");
            String id = scanner.nextLine();
            if(id.length() == 6 && !existingIds.contains(id)) {
                this.appointmentId = id;
                existingIds.add(id);
                break;
            }
            System.err.println("Mã phải đung 6 ký tự và không được trùng lặp!");
        }

        while (true) {
            System.out.println("Mời bạn nhập vào tên bệnh nhân từ 10-50 ký tự: ");
            String patientName = scanner.nextLine();
            if(patientName.length() < 10 || patientName.length() > 50) {
                System.err.println("Tên bệnh nhân phải có từ 10-50 ký tự!");
            }else {
                this.patientName = patientName;
                break;
            }
        }

        while (true) {
            System.out.println("Mời bạn nhập vào số điện thoại: ");
            String phoneNumber = scanner.nextLine();
            // Regex cho SĐT Việt Nam: bắt đầu bằng 0, tiếp theo là 3, 5, 7, 8, 9 và có 9 chữ số sau đó
            if (phoneNumber.matches("^(03|05|07|08|09)\\d{8}$")) {
                this.phoneNumber = phoneNumber;
                break;
            }
            System.err.println("Định dạng số điện thoại Việt Nam không hợp lệ!");
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.println("Nhập ngày hẹn (dd/MM/yyyy)): ");
            String appointmentDate = scanner.nextLine();
            try {
                this.appointmentDate = LocalDate.parse(appointmentDate, dateTimeFormatter);
                break;
            }catch (DateTimeParseException e){
                System.err.println("Định dạng ngày tháng năm (dd/MM/yyyy) bạn nhập không đúng!");
            }
        }

        while (true) {
            System.out.println("Mời bạn nhập tên bác sỹ phụ trách: ");
            String doctocName = scanner.nextLine();
            if (doctocName.length() < 200 && !doctocName.isEmpty()) {
                this.doctor = doctocName;
                break;
            }
            System.err.println("Tên người phụ trách không được để trong và tối đa 200 ký tự");
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", doctor='" + doctor + '\'' +
                '}';
    }
}
