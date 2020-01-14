package Service.Villa;

import Models.Villa;
import Repository.FuncWriteAndReadCSV;
import Ultils.Compare.VillaCompare;
import Ultils.Validation.ServiceValidate;
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

public class VillaServiceImpl implements VillaService, FuncWriteAndReadCSV<Villa>, Comparator<Villa> {

    private static final String PATH_FILE_VILLA = "src/Data/Villa.csv";
    private static final String[] FILE_HEADER_OF_VILLA = {"id", "nameService", "areaUsed", "rentalCost", "maxNumberOfCustomer",
            "typeRent", "roomStandard", "otherServiceDescription", "poolArea", "numberOfFloor"};

    @Override
    public void addNewVilla() {
        Scanner scanner = new Scanner(System.in);
        Villa villa = new Villa();
        villa.setId(UUID.randomUUID().toString().replace("-", ""));

        do {
            System.out.println("Enter Villa Name");
            villa.setNameService(scanner.nextLine());
        } while (!ServiceValidate.validateName(villa.getNameService()));

        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Enter areaUsed information: ");
                villa.setAreaUsed(scanner.nextDouble());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }

        } while (!ServiceValidate.validateAreaUsedOrPoolArea(villa.getAreaUsed()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Input AreaPool");
                villa.setPoolArea(scanner.nextDouble());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }

        } while (!ServiceValidate.validateAreaUsedOrPoolArea(villa.getPoolArea()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("Input Floor");
                villa.setNumberOfFloor(scanner.nextInt());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }

        } while (!ServiceValidate.validateFloor(villa.getNumberOfFloor()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("input other service description");
                villa.setOtherServiceDescription(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }

        } while (!ServiceValidate.validateServiceDescription(villa.getOtherServiceDescription()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("input number of people");
                villa.setMaxNumberOfCustomer(scanner.nextInt());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }
        } while (!ServiceValidate.validateMaxPeople(villa.getMaxNumberOfCustomer()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("input RentalCost");
                villa.setRentalCost(scanner.nextInt());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }
        } while (!ServiceValidate.validatePrice(villa.getRentalCost()));
        do {
            try {
                scanner = new Scanner(System.in);
                System.out.println("input Type rent");
                villa.setTypeRent(scanner.nextLine());
            } catch (Exception ex) {
                System.out.println("Input data not match validation");
            }
        } while (!ServiceValidate.validateName(villa.getTypeRent()));
        writeCsvFile(villa);
    }

    @Override
    public void showAllVilla() {
        List<Villa> villaList = readCsvFile();
        for (int i = 0; i < villaList.size(); i++) {
            System.out.println((i + 1) + ". \t");
            System.out.println(villaList.get(i).showInfor());
            System.out.println();
            System.out.println("===================================================================");
        }
    }

    @Override
    public Villa getVillaById(int id) {
        List<Villa> villaList = readCsvFile();
        Villa villa = villaList.get(id - 1);
        return villa;
    }

    @Override
    public Set<String> getNameServiceFromFileCSV(String path) {
        return null;
    }

    @Override
    public List<Villa> readCsvFile() {
        List<Villa> oldVillas = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_VILLA));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_VILLA).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                if (i == 0) {
                    i++;
                } else {
                    Villa villa = new Villa();
                    villa.setId(csvRecord.get(0));
                    villa.setNameService(csvRecord.get(1));
                    villa.setAreaUsed(Double.parseDouble(csvRecord.get(2)));
                    villa.setRentalCost(Double.parseDouble(csvRecord.get(3)));
                    villa.setMaxNumberOfCustomer(Integer.parseInt(csvRecord.get(4)));
                    villa.setTypeRent((csvRecord.get(5)));
                    villa.setRoomStandard(csvRecord.get(6));
                    villa.setOtherServiceDescription(csvRecord.get(7));
                    villa.setPoolArea(Double.parseDouble(csvRecord.get(8)));
                    villa.setNumberOfFloor(Integer.parseInt(csvRecord.get(9)));
                    oldVillas.add(villa);
                }
            }
            return oldVillas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TreeSet<Villa> readCsvFileNotDuplicate() {
        TreeSet<Villa> oldVillas = new TreeSet<>(new VillaCompare());
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_VILLA));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_VILLA).withIgnoreHeaderCase().withTrim());
            int i = 0;
            for (CSVRecord csvRecord : csvParser) {
                if (i == 0) {
                    i++;
                } else {
                    Villa villa = new Villa();
                    villa.setId(csvRecord.get(0));
                    villa.setNameService(csvRecord.get(1));
                    villa.setAreaUsed(Double.parseDouble(csvRecord.get(2)));
                    villa.setRentalCost(Double.parseDouble(csvRecord.get(3)));
                    villa.setMaxNumberOfCustomer(Integer.parseInt(csvRecord.get(4)));
                    villa.setTypeRent((csvRecord.get(5)));
                    villa.setRoomStandard(csvRecord.get(6));
                    villa.setOtherServiceDescription(csvRecord.get(7));
                    villa.setPoolArea(Double.parseDouble(csvRecord.get(8)));
                    villa.setNumberOfFloor(Integer.parseInt(csvRecord.get(9)));
                    oldVillas.add(villa);
                }
            }
            return oldVillas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeCsvFile(Villa villa) {
        try {
            List<Villa> oldVilla = readCsvFile();
            Writer writer = new PrintWriter(PATH_FILE_VILLA);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_VILLA));
            if (oldVilla != null) {
                for (Villa villa1 : oldVilla) {
                    csvPrinter.printRecord(Arrays.asList(villa1.getId(), villa1.getNameService(), villa1.getAreaUsed(), villa1.getRentalCost(),
                            villa1.getMaxNumberOfCustomer(), villa1.getTypeRent(), villa1.getRoomStandard(), villa1.getOtherServiceDescription(),
                            villa1.getPoolArea(), villa1.getNumberOfFloor()));
                    csvPrinter.flush();
                    System.out.println("Write csv file by using Apache libs successfully");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllVillaNotDuplicate() {
        TreeSet<Villa> villas = readCsvFileNotDuplicate();
        int count = 1;
        for (Villa villa : villas) {
            System.out.println(count + ". \t");
            System.out.println(villa.showInfor());
            System.out.println();
            System.out.println("=============================================================");
            count++;
        }
    }

    @Override
    public int compare(Villa o1, Villa o2) {
        return o1.getId().compareTo(o2.getId());
    }


}
