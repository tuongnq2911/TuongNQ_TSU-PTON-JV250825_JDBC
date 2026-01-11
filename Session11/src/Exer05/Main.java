package Exer05;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Event> eventList  = new ArrayList<>();

    public void addEvent(String name, LocalDateTime startDate, LocalDateTime endDate){
        Event event = new Event(name, startDate, endDate);
        eventList.add(event);
    }

    public void displayEventList(){
        System.out.println("Danh sách sự kiện: ");
        for (Event event : eventList){
            System.out.println(event);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main eventManager = new Main();

        while (true){
            String name = Validator.getString(scanner,"Nhập tên sự kiện( hoặc 'exit'' để thoát): ");
            if (name.equalsIgnoreCase("exit")){
                break;
            }

            LocalDateTime starDate = Validator.getDateTime(scanner, "Nhập thời gian bắt đầu (dd-MM-yyyy HH:mm): ");
            LocalDateTime endDate = Validator.getDateTime(scanner, "Nhập thời gian kết thúc (dd-MM-yyyy HH:mm):");

            eventManager.addEvent(name, starDate, endDate);
        }
        eventManager.displayEventList();
        scanner.close();
    }
}
