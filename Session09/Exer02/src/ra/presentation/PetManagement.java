package ra.presentation;

import jdk.jshell.spi.ExecutionControl;
import ra.entity.Cat;
import ra.entity.Dog;
import ra.entity.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetManagement {
    private static List<Pet> listPets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n*********************QUẢN LÝ THÚ CƯNG********************");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            try{
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:showAllPets();
                    break;
                    case 2:addPet();
                    break;
                    case 3:makeSpeak();
                    break;
                    case 4:deletePets();
                    break;
                    case 5:findPets();
                    break;
                    case 6:System.exit(0);
                    default:
                        System.err.println("Lựa chọn của bạn không hợp lệ !!!");
                }
            }
            catch (NumberFormatException e){
                System.err.println("Định dạng nhập không hợp lệ");
            }
        }
    }
    private static void showAllPets() {
        if (listPets.isEmpty()) {
            System.out.println("Danh sách thu cưng trống!");
            return;
        }
        for (Pet pet : listPets) {
            pet.displayData();
            pet.speak();
        }
    }

    private static void addPet() {
        System.out.println("Mời bạn chọn loại thú cưng 1. Dog | 2. Cat: ");
        int type = Integer.parseInt(sc.nextLine());
        Pet pet = (type == 1) ? new Dog() : new Cat();
        pet.inputData(sc, listPets);
        listPets.add(pet);
        System.out.println("Đã thêm thành công !!");
    }
    private static void makeSpeak(){
        System.out.println("Thú cưng kêu: ");
        for (Pet pet : listPets) {
            System.out.print(pet.getPetName() + " kêu ");
            pet.speak();
        }
    }
    private static void deletePets() {
        System.out.println("Mời bạn nhập mã số thú cưng cần xoá: ");
        String id = sc.nextLine();
        boolean remove = listPets.removeIf(pet ->  pet.getPetId().equalsIgnoreCase(id));
        if (remove) {
            System.out.println("Xoá thành công mã số thú cưng" + id);
        }else {
            System.out.println("Mã thú cưng không tồn tại");
        }
    }

    private  static void findPets() {
        System.out.println("Mời bạn nhập tên thú cưng: ");
        String name =  sc.nextLine().toLowerCase();
        boolean found = false;
        for (Pet pet : listPets) {
            if (pet.getPetName().toLowerCase().contains(name)) {
                pet.displayData();
                pet.speak();
                found = true;
            }
        }
        if (!found) {
            System.err.println("Không tìm thấy tên thú cưng "+ name + " mà bạn đã nhập");
        }
    }
}
