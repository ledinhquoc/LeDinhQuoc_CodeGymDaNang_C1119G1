package Service.Booking;

import Models.Customer;
import Models.Service;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final String PATH_FILE_BOOKING = "src/Data/Booking.csv";
    private static final String[] FILE_HEADER_OF_BOOKING = {"id", "name", "birthday", "gender"
            , "idCard", "phone", "email", "customerType"
            , "address", "useService"};
    @Override
    public void addNewBooking(Customer customer){
            writeCsvFile(customer);
    }

    @Override
    public void showAllBooking(){
        List<Customer> customers = readCsvFile();
        for (int i = 0; i < customers.size();i++){
            System.out.println(
                    i+ "."
                    + "\t id: " + customers.get(i).getId()
                            + "\t id: " + customers.get(i).getId()
                            + "\t name: " + customers.get(i).getName()
                            + "\t birthday: " + customers.get(i).getBirthday()
                            + "\t gender: " + customers.get(i).getGender()
                            + "\t address: " + customers.get(i).getPhone()
                            + "\t email: " + customers.get(i).getEmail()
                            + "\t customer Type: " + customers.get(i).getCustomerType()
                            + "\t address: " + customers.get(i).getAddress()
                            + "\t useService: " + customers.get(i).getUseService());
        }
    }
    @Override
    public Set<String> getNameServiceFromFileCSV(String path){
        return null;
    }
    @Override
    public void writeCsvFile(Customer customer){
        try {
        List<Customer> customers = readCsvFile();
            Writer writer = new PrintWriter(PATH_FILE_BOOKING);
            CSVPrinter csvPrinter = new CSVPrinter(writer,CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_BOOKING));
            if (customers != null){
                for (Customer customer1: customers){
                    csvPrinter.printRecord(Arrays.asList(customer1.getId(),customer1.getName(),customer1.getBirthday()
                            ,customer1.getGender(),customer1.getIdCard(),customer1.getPhone(),customer1.getEmail(),customer1.getCustomerType()
                            ,customer1.getAddress(),customer1.getUseService().getId()));
                }
            }
            csvPrinter.printRecord(Arrays.asList(customer.getId(),customer.getName(),customer.getBirthday()
                    ,customer.getGender(),customer.getIdCard(),customer.getPhone(),customer.getEmail(),customer.getCustomerType()
                    ,customer.getAddress(),customer.getUseService().getId()));
            csvPrinter.flush();
            System.out.println("Write csv file by using new Apache lib successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> readCsvFile() {
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_BOOKING));
            CSVParser csvParser = new CSVParser(reader,CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_BOOKING).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecord: csvParser){
                if (i == 0){
                    i++;
                }else {
                    Customer customer = new Customer();
                    customer.setId(csvRecord.get(0));
                    customer.setName(csvRecord.get(1));
                    customer.setBirthday(csvRecord.get(2));
                    customer.setGender(csvRecord.get(3));
                    customer.setIdCard(csvRecord.get(4));
                    customer.setPhone(csvRecord.get(5));
                    customer.setEmail(csvRecord.get(6));
                    customer.setCustomerType(csvRecord.get(7));
                    customer.setAddress(csvRecord.get(8));
                    customer.setIdService(csvRecord.get(9));
                    customers.add(customer);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
    }
        return customers;
        }
    @Override
    public TreeSet<Customer> readCsvFileNotDuplicate(){
        return null;
    }

}
