package Service.Customer;

import Models.Customer;
import Repository.FuncWriteAndReadCSV;

public interface CustomerService extends FuncWriteAndReadCSV<Customer> {
    void addNewCustomer();
    void showAllCustomer();
    void showAllCustomerNoSort();
    Customer getCustomerByChoice(int choice);
}
