package Service.Customer;

import Models.Customer;
import Ultils.Sort.NameCustomerComparator;
import Ultils.Validation.CustomerValidate;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class CustomerServiceImpl implements CustomerService {
    private static final String PATH_FILE_CUSTOMER = "src/Data/Customer.csv";
    private static final String[] FILE_HEADER_OF_CUSTOMER = {"id", "name", "birthday", "gender"
            , "idCard", "phone", "email", "customerType"
            , "address", "useService"};
    @Override
    public void addNewCustomer(){
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString().replace("-",""));

        do {
            System.out.println("Input Name Customer");
            customer.setName(scanner.nextLine());
        }while (!CustomerValidate.validateName(customer.getName()));

        do {
            scanner = new Scanner(System.in);
            System.out.println("Input birthday customer");
            customer.setBirthday(scanner.nextLine());
        }while (!CustomerValidate.validateBirthday(customer.getBirthday()));

        String gender;
        do {
            scanner = new Scanner(System.in);
            System.out.println("Input gender customer");
            gender = CustomerValidate.validateGender(scanner.nextLine());
            customer.setGender(gender);
        }while (gender.equals("false"));
        do {
            scanner = new Scanner(System.in);
            System.out.println("idCard");
            customer.setIdCard(scanner.nextLine());
        }while (!CustomerValidate.validateIdCard(customer.getIdCard()));
        System.out.println("phone: ");
        customer.setPhone(scanner.nextLine());
        do {
            scanner = new Scanner(System.in);
            System.out.println("email: ");
            customer.setEmail(scanner.nextLine());
        }while (!CustomerValidate.validateEmail(customer.getEmail()));

        System.out.println("customer type: ");
        customer.setCustomerType(scanner.nextLine());
        System.out.println("customer Address: ");
        customer.setAddress(scanner.nextLine());
        System.out.println("use service");
        writeCsvFile(customer);
    }
    @Override
    public void showAllCustomer(){
        List<Customer> customers = readCsvFile();
        customers.sort(new NameCustomerComparator());
        for (int i = 0; i < customers.size();i++){
            System.out.println((i+1) + ". \t");
            System.out.println(customers.get(i).showInfo());
            System.out.println();
            System.out.println("=================================================================");
        }
    }

    @Override
    public void showAllCustomerNoSort() {
        List<Customer> customers = readCsvFile();
        for (int i = 0; i < customers.size();i++){
            System.out.println(". \t");
            System.out.println(customers.get(i).showInfo());
            System.out.println();
            System.out.println("===============================================================");
        }
    }

    @Override
    public Customer getCustomerByChoice(int choice){
        List<Customer> customerList = readCsvFile();
        Customer customer = customerList.get(choice - 1);
        return customer;
    }
    @Override
    public Set<String> getNameServiceFromFileCSV(String path){
        return null;
    }
    @Override
    public void writeCsvFile(Customer customer){
        try {
            List<Customer> customers = readCsvFile();
            Writer writer = new PrintWriter(PATH_FILE_CUSTOMER);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_CUSTOMER));
            if (customers != null){
                for (Customer customer1: customers){
                    csvPrinter.printRecord(Arrays.asList(customer1.getId(),customer1.getName(),customer1.getBirthday(),customer1.getGender(),
                            customer1.getIdCard(),customer1.getPhone(),customer1.getEmail(),customer1.getCustomerType(),customer1.getAddress(),
                            customer1.getUseService()));
                }
            }
            csvPrinter.printRecord(Arrays.asList(customer.getId(),customer.getName(),customer.getBirthday(),customer.getGender(),
                    customer.getIdCard(),customer.getPhone(),customer.getEmail(),customer.getCustomerType(),customer.getAddress(),
                    customer.getUseService()));
            csvPrinter.flush();
            System.out.println("Write csv file by using new Apache lib successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> readCsvFile(){
        List<Customer> customers = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_CUSTOMER));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_CUSTOMER).withIgnoreHeaderCase().withTrim());
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
      return customers;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
        @Override
    public TreeSet<Customer> readCsvFileNotDuplicate(){
        return null;
        }


}
