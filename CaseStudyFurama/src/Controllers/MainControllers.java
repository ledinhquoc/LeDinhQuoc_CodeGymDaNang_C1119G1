package Controllers;

import Models.*;
import Service.Booking.BookingService;
import Service.Booking.BookingServiceImpl;
import Service.BookingCinema4D.BookingCinema4DService;
import Service.BookingCinema4D.BookingCinema4DServiceImpl;
import Service.Customer.CustomerService;
import Service.Customer.CustomerServiceImpl;
import Service.Employee.EmployeeService;
import Service.Employee.EmployeeServiceImpl;
import Service.FilingCabinetsService.FilingCabinetsService;
import Service.FilingCabinetsService.FilingCabinetsServiceImpl;
import Service.House.HouseService;
import Service.House.HouseServiceImpl;
import Service.Room.RoomService;
import Service.Room.RoomServiceImpl;
import Service.Villa.VillaService;
import Service.Villa.VillaServiceImpl;


import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class MainControllers {
    private VillaService villaService = new VillaServiceImpl();
    private HouseService houseService = new HouseServiceImpl();
    private RoomService roomService = new RoomServiceImpl();
    private CustomerService customerService = new CustomerServiceImpl();
    private BookingService bookingService = new BookingServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private BookingCinema4DService bookingCinema4DService = new BookingCinema4DServiceImpl();
    private FilingCabinetsService filingCabinetsService = new FilingCabinetsServiceImpl();

    public void displayMainMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------FURAMA MANAGEMENT SYSTEM------------");
        System.out.println("\n1. Add New Service" +
                "\n2. Show service" +
                "\n3. Add new customer" +
                "\n4. Show information customer" +
                "\n5. Add new booking" +
                "\n6. Show information Employee" +
                "\n7. Show booking cinema 4D" +
                "\n8. Search filing Cabinets" +
                "\n9. Exit" +
                "\nPlease select one function below");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                addNewService();
                break;
            case 2:
                showServices();
                break;
            case 3:
                customerService.addNewCustomer();
                displayMainMenu();
                break;
            case 4:
                customerService.showAllCustomer();
                displayMainMenu();
                break;
            case 5:
                addNewBooking();
                break;
            case 6:
                displayEmployee();
                displayMainMenu();
                break;
            case 7:
                showBookingCinema();
                displayMainMenu();
                break;
            case 8:
                searchFilingCabinetsOfEmployee();
                displayMainMenu();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                displayMainMenu();
        }
    }


    private void addNewService() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Add New Villa" +
                "\n2. Add new House" +
                "\n3. Add new Room" +
                "\n4. Back to menu" +
                "\n5. Exit" +
                "\nPlease select one function below");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                villaService.addNewVilla();
                displayMainMenu();
                break;
            case 2:
                houseService.addNewHouse();
                displayMainMenu();
                break;
            case 3:
                roomService.addNewRoom();
                displayMainMenu();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("\nError. Back to menu");
                displayMainMenu();
        }
    }

    private void showServices() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Show All Villa" +
                "\n2. Show All House" +
                "\n3. Show All Room" +
                "\n4. Show All Villa Not Duplicate" +
                "\n5. Show All House Not Duplicate" +
                "\n6. Show All Room Not Duplicate" +
                "\n7. Back to menu");
        System.out.println("input your choice");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                villaService.showAllVilla();
                showServices();
                break;
            case 2:
                houseService.showAllHouse();
                showServices();
                break;
            case 3:
                roomService.showAllRoom();
                showServices();
                break;
            case 4:
                villaService.showAllVillaNotDuplicate();
                showServices();
                break;
            case 5:
                houseService.showAllHouseNotDuplicate();
                showServices();
                break;
            case 6:
                roomService.showAllRoomNotDuplicate();
                showServices();
                break;
            case 7:
                displayMainMenu();
                break;
            default:
                showServices();
        }
    }

    public void addNewBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1. Booking Villa" +
                "\n2. Booking House" +
                "\n3. Booking Room" +
                "\n4. Back to menu");
        System.out.println("input your choice");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                bookingVilla();
                addNewBooking();
                break;
            case 2:
                bookingHouse();
                addNewBooking();
                break;
            case 3:
                bookingRoom();
                addNewBooking();
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                showServices();
        }
    }

    private void bookingVilla() {
        Scanner scanner;
        villaService.showAllVilla();
        scanner = new Scanner(System.in);
        System.out.println("Choice service: ");
        int serviceId = scanner.nextInt();
        Villa villa = villaService.getVillaById(serviceId);
        customerService.showAllCustomerNoSort();
        System.out.println("Choice customer");
        int choiceCustomer = scanner.nextInt();
        Customer customer = customerService.getCustomerByChoice(choiceCustomer);
        customer.setUseService(villa);
        customer.setIdService(customer.getUseService().getId());
        System.out.println(customer.showInfo());
        bookingService.addNewBooking(customer);
    }

    private void bookingHouse() {
        Scanner scanner;
        houseService.showAllHouse();
        scanner = new Scanner(System.in);
        System.out.println("Choice service: ");
        int choiceHouse = scanner.nextInt();
        House house = houseService.getHouseById(choiceHouse);
        customerService.showAllCustomerNoSort();
        System.out.println("Choice customer");
        int choiceCustomer = scanner.nextInt();
        Customer customer = customerService.getCustomerByChoice(choiceCustomer);
        bookingService.addNewBooking(customer);
    }

    private void bookingRoom() {
        Scanner scanner;
        roomService.showAllRoom();
        scanner = new Scanner(System.in);
        System.out.println("Choice service: ");
        int serviceId = scanner.nextInt();
        Room room = roomService.getRoomById(serviceId);
        customerService.showAllCustomerNoSort();
        System.out.println("Choice customer");
        int choiceCustomer = scanner.nextInt();
        Customer customer = customerService.getCustomerByChoice(choiceCustomer);
        bookingService.addNewBooking(customer);
    }

    private void displayEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        for (Employee employee : employees) {
            System.out.println("===========================================================================");
            System.out.println(employee.toString());
        }
    }

    private void showBookingCinema() {
        Queue<Customer> customers = bookingCinema4DService.getAllBookingCinema();
        while (true) {
            Customer customer = customers.poll();
            if (customer == null) {
                break;
            }
            System.out.println(customer.showInfo());
        }
    }

    private void searchFilingCabinetsOfEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID of Employee");
        String idEmployee = scanner.nextLine();
        Employee employee = filingCabinetsService.findEmployeeById(idEmployee);
        if (employee == null) {
            System.out.println("Not found Cabinets!");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.println(employee.toString());
            System.out.println("-----------------------------------------------");
        }
    }
}
