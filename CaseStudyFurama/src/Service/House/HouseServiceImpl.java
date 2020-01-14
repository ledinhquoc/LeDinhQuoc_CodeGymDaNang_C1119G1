package Service.House;

import Models.House;
import Service.House.HouseService;
import Ultils.Compare.HouseCompare;
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

public class HouseServiceImpl implements HouseService {
    public static final String PATH_FILE_HOUSE = "src/Data/House.csv";
    public static final String[] FILE_HEADER_OF_HOUSE = {
            "id","nameService","areaUsed","rentalCost","maxNumberOfCustomer","typeRent","roomStandard","otherServiceDescription",
            "numberOfFloor"};
    @Override
    public void addNewHouse(){
        Scanner scanner = new Scanner(System.in);
        House house = new House();
        house.setId(UUID.randomUUID().toString().replace("-",""));
        System.out.println("Input House Name");
        house.setNameService(scanner.nextLine());
        System.out.println("Input area Used");
        house.setAreaUsed(scanner.nextDouble());
        System.out.println("input rentalCost");
        house.setRentalCost(scanner.nextDouble());
        scanner = new Scanner(System.in);
        System.out.println("input other service description");
        house.setOtherServiceDescription(scanner.nextLine());
        System.out.println("input number of floor");
        house.setNumberOfFloor(scanner.nextInt());
        System.out.println("input max number of customer");
        house.setMaxNumberOfCustomer(scanner.nextInt());
        scanner = new Scanner(System.in);
        System.out.println("Input type rent");
        house.setRoomStandard(scanner.nextLine());

        writeCsvFile(house);
    }
    @Override
    public void showAllHouse(){
        List<House> houseList = readCsvFile();
        for (int i = 0;i < houseList.size();i++){
            System.out.println((i + 1) + ". \t");
            System.out.println(houseList.get(i).showInfor());
            System.out.println();
            System.out.println("===================================================================");
        }
    }
    @Override
    public House getHouseById(int id){
        List<House> houseList = readCsvFile();
        House house = houseList.get(id -1);
        return house;
    }
    @Override
    public void showAllHouseNotDuplicate(){
        TreeSet<House> houses = new TreeSet<>(new HouseCompare());
        int count = 1;
        for (House house: houses){
            System.out.println(count + ". \t");
            System.out.println(house.showInfor());
            System.out.println();
            System.out.println("========================================================================");
            count++;
        }
    }
    @Override
    public Set<String> getNameServiceFromFileCSV(String path){
        return null;
    }

    @Override
    public void writeCsvFile(House house) {
        try {
            List<House> oldHouse = readCsvFile();
            Writer writer = new PrintWriter(PATH_FILE_HOUSE);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_HOUSE));
            if (oldHouse != null) {
                for (House house1 : oldHouse) {
                    csvPrinter.printRecord(Arrays.asList(house1.getId(), house1.getNameService(), house1.getAreaUsed(), house1.getRentalCost()
                            , house1.getMaxNumberOfCustomer(), house1.getTypeRent(), house1.getRoomStandard(), house1.getOtherServiceDescription(),
                            house1.getNumberOfFloor()));
                }
            }

            csvPrinter.printRecord(Arrays.asList(house.getId(), house.getNameService(), house.getAreaUsed(), house.getRentalCost()
                    , house.getMaxNumberOfCustomer(), house.getTypeRent(), house.getRoomStandard(), house.getOtherServiceDescription(),
                    house.getNumberOfFloor()));
            csvPrinter.flush();
            System.out.println("Write csv file by using new Apache lib successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<House> readCsvFile() {
        List<House> oldHouse = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_HOUSE));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_HOUSE).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecords : csvParser) {
                if (i == 0) {
                    i++;
                } else {
                    House house = new House();
                    house.setId(csvRecords.get(0));
                    house.setNameService(csvRecords.get(1));
                    house.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                    house.setRentalCost(Double.parseDouble(csvRecords.get(3)));
                    house.setMaxNumberOfCustomer(Integer.parseInt(csvRecords.get(4)));
                    house.setTypeRent(csvRecords.get(5));
                    house.setRoomStandard(csvRecords.get(6));
                    house.setOtherServiceDescription(csvRecords.get(7));
                    house.setNumberOfFloor(Integer.parseInt(csvRecords.get(8)));
                    oldHouse.add(house);
                }
            }
            return oldHouse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TreeSet<House> readCsvFileNotDuplicate() {
        TreeSet<House> oldHouse = new TreeSet<>(new HouseCompare());
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_HOUSE));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_HOUSE).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecords : csvParser) {
                if (i == 0) {
                    i++;
                } else {
                    House house = new House();
                    house.setId(csvRecords.get(0));
                    house.setNameService(csvRecords.get(1));
                    house.setAreaUsed(Double.parseDouble(csvRecords.get(2)));
                    house.setRentalCost(Double.parseDouble(csvRecords.get(3)));
                    house.setMaxNumberOfCustomer(Integer.parseInt(csvRecords.get(4)));
                    house.setTypeRent(csvRecords.get(5));
                    house.setRoomStandard(csvRecords.get(6));
                    house.setOtherServiceDescription(csvRecords.get(7));
                    house.setNumberOfFloor(Integer.parseInt(csvRecords.get(8)));
                    oldHouse.add(house);
                }
            }
            return oldHouse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    }


