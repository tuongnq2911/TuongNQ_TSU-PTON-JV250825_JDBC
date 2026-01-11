package Exer06;

import java.util.ArrayList;

public class OrderManager implements Manage<Order> {
    private ArrayList<Order> orders;
    public OrderManager() {
        orders = new ArrayList<>();
    }
    @Override
    public void add(Order order) {
        orders.add(order);
    }

    @Override
    public void update(int index, Order item) {
        if (index >= 0 && index < orders.size()) {
            orders.set(index, item);
        }else {
            throw new IndexOutOfBoundsException("Mã đơn hàng không tồn tại!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orders.size()) {
            orders.remove(index);
        }else {
            throw new IndexOutOfBoundsException("Mã đơn hàng không tồn tại !");
        }
    }

    @Override
    public void display() {
        if (orders.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào trong danh sách!");
        }else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println((i + 1) + ". " + orders.get(i));
            }
        }
    }

    public int findIndexByOrderId(String index){
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId().equals(index)) {
                return i;
            }
        }return -1;
    }
}
