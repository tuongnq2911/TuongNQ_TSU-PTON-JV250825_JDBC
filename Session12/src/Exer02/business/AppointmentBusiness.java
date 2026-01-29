package Exer02.business;

import Exer02.entity.Appointment;

import java.util.*;
import java.util.stream.Collectors;

public class AppointmentBusiness {
    private static List<Appointment> appointmentList = new ArrayList<>();

    public static void addAppointment(Scanner scanner){
        System.out.println("Nhập số lượng lịch hẹn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < n; i++){
            System.out.println("Lịch hẹn thứ "+ (i + 1)+ ":");
            Appointment appointment = new Appointment();
            //Check trùng lặp ID
            Set<String> currentIds = appointmentList.stream().map(Appointment::getAppointmentId)
                    .collect(Collectors.toSet());
            appointment.inputData(scanner, currentIds);
            appointmentList.add(appointment);
        }
    }

    public static void displaySortedByDateASC() {
        if (appointmentList.isEmpty()) {
            System.err.println("Danh sách trống!");
            return;
        }
        appointmentList.sort(Comparator.comparing(Appointment::getAppointmentDate));
        appointmentList.forEach(System.out::println);
    }

    public static void searchByName(Scanner scanner){
        System.out.println("Mời bạn nhập tên bệnh nhân cần tìm: ");
        String patientName = scanner.nextLine().toLowerCase();
        List<Appointment> result = appointmentList.stream()
                .filter(a -> a.getPatientName().toLowerCase().contains(patientName))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            System.err.println("Không tìm thấy tên bệnh nhân: " + patientName);
        }else {
            result.forEach(System.out::println);
        }
    }

    public static void updateAppointment(Scanner scanner){
        System.out.println("Nhập mã lịch hẹn cần cập nhật: ");
        String appointmentId = scanner.nextLine();
        Optional<Appointment>  optional = appointmentList.stream()
                .filter(a -> a.getAppointmentId().equals(appointmentId)).findFirst();

        optional.ifPresentOrElse(appointment ->  {
            System.out.print("Tên bệnh nhân mới: ");
            appointment.setPatientName(scanner.nextLine());
            System.out.print("Nhập vào SĐT mới: ");
            appointment.setPhoneNumber(scanner.nextLine());
            System.out.println("Cập nhật thành công!");
        }, () -> System.err.println("Mã lịch hẹn không tồn tại!"));
    }

    public static void deleteAppointment(Scanner scanner){
        System.out.println("Nhập vào mã lịch hẹn cần xoá: ");
        String appointmentId = scanner.nextLine();
        appointmentList.stream().filter(a -> a.getAppointmentId().equals(appointmentId))
                .findFirst().ifPresentOrElse(appointment -> {
                    System.out.print("Xác nhận xoá " +appointmentId + "? Y/N: ");
                    if (scanner.nextLine().equalsIgnoreCase("Y")) {
                        appointmentList.remove(appointment);
                        System.out.println("Đã xoá thành công.");
                    }
                },() -> System.err.println("Không tìm thấy mã!")
                );
    }

    public static void showStats(){
        System.out.println("Tổng số lịch hẹn: " + appointmentList.size());
        Map<String, Long> stats = appointmentList.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor, Collectors.counting()));
        stats.forEach((dr, count) -> System.out.println("Bác sỹ: "+ dr + ": " + count + " lịch"));
    }
}
