package Exer05;

import java.util.ArrayList;

public class InvoiceManager implements Manage<Invoice>{
    public ArrayList<Invoice> invoices;
    public InvoiceManager(){
        invoices = new ArrayList<>();
    }

    @Override
    public void add(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public void update(int index, Invoice item) {
        if(index >= 0 && index<invoices.size()){
            invoices.set(index, item);
        }
    }

    @Override
    public void delete(int index) {
        if(index >= 0 && index<invoices.size()){
            invoices.remove(index);
        }
    }

    @Override
    public void display() {
        if(invoices.isEmpty()){
            System.out.println("Chưa có hoá đơn trong danh sách!");
        }else {
            for (int i = 0; i < invoices.size(); i++) {
                System.out.println((i + 1) + ". " + invoices.get(i));
            }
        }
    }

    public int findIndexById(int id){
        for(int i = 0; i < invoices.size(); i++){
            if(invoices.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
}
