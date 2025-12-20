//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    StringBuilder stb = new StringBuilder("Hello,Java World!");
    System.out.println("Chuỗi ban đầu là: "+stb);
    stb.delete(5,10);
        System.out.println("Chuỗi mới sau khi xoá là: "+stb);

    int startIndex = stb.indexOf("World");
    int endIndex = startIndex + "World".length();
    if(startIndex != -1) {
        stb.replace(startIndex,endIndex,"Universe");
    }
        System.out.println("Chuỗi sau khi thay thế là: "+stb);
    }
}