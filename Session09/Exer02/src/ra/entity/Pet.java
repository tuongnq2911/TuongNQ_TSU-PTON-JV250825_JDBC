package ra.entity;

import java.util.List;
import java.util.Scanner;

public abstract class Pet {
    private String petId;
    private String petName;
    private int age;
    // Contractor không tham số
    public Pet() {}
    // Contractor đầy đủ tham số
    public Pet(String petId, String petName, int age) {
        this.petId = petId;
        this.petName = petName;
        this.age = age;
    }

    // Getter và Setter

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void inputData(Scanner scanner, List<Pet> petList) {
        //  1. Mã thủ cưng bao gồm 1 ký tự (C hoặc D) và 3 số không trùng lặp
        while (true) {
            System.out.println("Nhập mã thú cưng theo cú pháp (Cxxx hoặc Dxxx): ");
            String id = scanner.nextLine();
            if (!id.matches("^[CD]\\d{3}$")) {
                System.err.println("Lỗi: Mã phải có 4 ký tự, bắt đầu bằng C hoặc D, sau đó là 3 số!");
                continue;
            }
            if (this instanceof Cat && !id.startsWith("C")) {
                System.err.println("Lỗi: Đây là Mèo, mã phải bắt đầu bằng chữ 'C'!");
                continue;
            }
            if (this instanceof Dog && !id.startsWith("D")){
                System.err.println("Lỗi: Đây là Chó, mã phải bắt đầu bằng chữ 'D'!");
                continue;
            }
                boolean isExist = false;
                for (Pet pet : petList) {
                    if (pet.getPetId().equalsIgnoreCase(id)) {
                        isExist = true;
                        break;
                    }
                }

                // Mã thú cưng không được trùng
                if (!isExist) {
                    this.petId = id;
                    break;
                }else {
                    System.err.println("Mã thú cưng đã tồn tại");
                }
        }
        // 2. Tên thú cưng ( 20-50 ký tự )
        while (true) {
            System.out.println("Mời bạn nhập tên thú cưng trong khoảng 20-50 ký tự: ");
            String name = scanner.nextLine();
            if (name.length() >= 20 && name.length() <= 50 ) {
               this.petName = name;
               break;
            }else {
                System.err.println("Tên thú cưng phải có từ 20 tới 50 ký tự!");
            }
        }

        // Tuổi: số nguyên có giá trị lớn hơn 0
        while (true) {
            try {
                System.out.println("Mời bạn nhập vào tuổi của thủ cưng: ");
                int age = Integer.parseInt(scanner.nextLine());
                if (age > 0) {
                    this.age = age;
                    return;
                }else {
                    System.err.println("Tuổi của thú cưng phải lớn hơn 0!");
                }
            }
            catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số nguyên");
            }
        }
    }
    public void displayData(){
        System.out.printf("ID: %-5s | Tên: %-30s | Tuổi: %-5d |", petId, petName, age);
    }
    public abstract void speak();
}
