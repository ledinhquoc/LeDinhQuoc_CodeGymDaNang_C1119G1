package Service.BookingCinema4D;

import Models.Customer;
import Service.BookingCinema4D.BookingCinema4DService;

import java.util.LinkedList;
import java.util.Queue;

public class BookingCinema4DServiceImpl implements BookingCinema4DService {
        private static Queue<Customer> customers = new LinkedList<>();
        static {
            customers.add(new Customer("001","Quoc","01/06/1993","Male","201647394","0985634701","elvisle93@gmail.com","new member","Đà Nẵng",null));
            customers.add(new Customer("002","Trieu","23/12/1991","Male","200145647","0905442117","abc@gmail.com","gold member","Quảng Trị",null));
            customers.add(new Customer("003","Vu","11/07/2002","Female","201113553","0989234113","abcd@gmail.com","diamond","Quảng Bình",null));
            customers.add(new Customer("004","Viet","31/3/1997","Male","201543786","0905785667","abcde@gmail.com","Silver","Ho Chi Minh city",null));
        }
        @Override
    public Queue<Customer> getAllBookingCinema(){
            return customers;
        }
}
