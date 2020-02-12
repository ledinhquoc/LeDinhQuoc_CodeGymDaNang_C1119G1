package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String birthday;
    private String address;
    private String image;
    private static List<Customer> list;

    public Customer(String name, String birthday, String address, String image) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.image = image;
    }

    static {
        list = new ArrayList<>();
        list.add(new Customer("Nguyen Duy Vu","22/11/2000","Quang Binh","/ddd"));
        list.add(new Customer("Tran Minh Trieu","22/11/2001","Quang Ngai","/ddd"));
        list.add(new Customer("Bui Duc Hoang","22/11/2002","Quang Tri","/ddd"));
        list.add(new Customer("Nguyen Phu Quy","22/11/1999","Da Nang","/ddd"));
        list.add(new Customer("Le Ngoc Huy","22/12/2000","Da Nang","/ddd"));
        list.add(new Customer("Nguyen Kim Quoc Viet","21/12/2000","TP HCM","/ddd"));
        list.add(new Customer("Truong Van Toan","22/10/2000","Da Nang","/ddd"));
    }


    public static List<Customer> getCustomer(){
        return list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
