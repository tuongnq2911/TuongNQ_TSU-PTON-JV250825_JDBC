package Exer03;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatApplication chatApplication = new ChatApplication();

        while (true) {
            System.out.println("Nhập tên người gửi (hoặc 'Exit' đẻ thoát): ");
            String sender = scanner.nextLine();
            if (sender.equalsIgnoreCase("Exit")) {
                break;
            }
            System.out.println(" Nhập nội dung tin nhắn");
            String content = scanner.nextLine();
            chatApplication.sendMessage(sender, content);

            System.out.println("Nhập 'History' để xem lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "history":
                    chatApplication.displayMessage();
                    break;
                case "filter":
                    System.out.println("Nhập tên người gửi để lọc: ");
                    String filterSender = scanner.nextLine();
                    chatApplication.filterMessagesBySender(filterSender);
                    break;
                case "date":
                    LocalDateTime date = Validator.getDate(scanner, "Nhập ngày (DD-MM-YYYY): ");
                    chatApplication.filterMessagesByDate(date);
                    break;
                default:
                    System.out.println(" Lệnh nhập không hợp lệ.");
                    break;
            }
        }
        scanner.close();
    }
}
