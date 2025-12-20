//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    int interations = 1000000;
    long startTime = System.currentTimeMillis();
    StringBuilder stb = new StringBuilder("Hello");
    for (int i = 0; i < interations; i++) {
        stb.append("World");
    }
    long endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện StringBuilder là: " + (endTime - startTime) + "ms");
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < interations; i++) {
            sbf.append("World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Thời gian thực hiện StringBuffer là: " + (endTime - startTime) + "ms");

        System.out.println("Đang chạy thử với chuỗi String có thể sẽ mất nhiều thời gian");
        startTime = System.currentTimeMillis();
        String str = ("Hello");
        for (int i = 0; i < interations; i++) {
            str += "World";
            if (i == 10000){
                System.out.println("Đã chạy tới "+ i + "lần, chạy hết sẽ tốn thêm khoảng thoài gian lớn nữa");
        }
        endTime = System.currentTimeMillis();
            System.out.println("Tổng thời gian thực hiển trên chuỗi String là: " + (endTime - startTime) + "ms");
        }
    }
}