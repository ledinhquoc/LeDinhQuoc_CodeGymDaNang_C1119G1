package Service.Booking;

import Models.Customer;
import Repository.FuncWriteAndReadCSV;

public interface BookingService extends FuncWriteAndReadCSV<Customer> {
           void addNewBooking(Customer customer);
               void showAllBooking();

}
