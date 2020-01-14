package Service.Room;

import Models.Room;
import Service.Room.RoomService;
import Ultils.Compare.RoomCompare;
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

public class RoomServiceImpl implements RoomService {
    private static final String PATH_FILE_ROOM = "src/Data/Room.csv";
    private static final String[] FILE_HEADER_OF_ROOM = {"id", "nameService", "areaUsed", "rentalCost", "maxNumberOfCustomer",
            "typeRent","freeService"};
    @Override
    public void addNewRoom() {
        Scanner scanner = new Scanner(System.in);
        Room room = new Room();
        room.setId(UUID.randomUUID().toString().replace("-",""));
        System.out.println("Input room name");
        room.setNameService(scanner.nextLine());
        System.out.println("Input area used");
        room.setAreaUsed(scanner.nextDouble());
        System.out.println("Input RentalCost");
        room.setRentalCost(scanner.nextDouble());
        System.out.println("input max number of customer");
        room.setMaxNumberOfCustomer(scanner.nextInt());
        scanner = new Scanner(System.in);
        System.out.println("input type rent");
        room.setTypeRent(scanner.nextLine());
        System.out.println("input free service");
        room.setFreeService(scanner.nextLine());
        writeCsvFile(room);
    }
    @Override
    public void showAllRoom(){
        List<Room> roomList = readCsvFile();
        for (int i = 0; i < roomList.size(); i++){
            System.out.println((i + 1) + ". \t");
            System.out.println(roomList.get(i).showInfor());
            System.out.println();
            System.out.println("====================================================================");
        }
    }

    @Override
    public Room getRoomById(int id) {
        List<Room> rooms = readCsvFile();
        Room room = rooms.get(id - 1);
        return room;
    }


    @Override
    public void showAllRoomNotDuplicate() {
            TreeSet<Room> roomTreeSet = readCsvFileNotDuplicate();
            int count = 1;
            for (Room room: roomTreeSet){
                System.out.println(count + ". \t");
                System.out.println(room.showInfor());
                System.out.println();
                System.out.println("==================================================================");
                count++;
            }
    }

    @Override
    public Set<String> getNameServiceFromFileCSV(String path) {
        return null;
    }

    @Override
    public void writeCsvFile(Room room) {
        try {
            List<Room> oldRoom = readCsvFile();
            Writer writer = new PrintWriter(PATH_FILE_ROOM);
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_ROOM));
            if (oldRoom != null){
                for (Room room1: oldRoom){
                    csvPrinter.printRecord(Arrays.asList(room1.getId(),room1.getNameService(),room1.getAreaUsed(),room1.getRentalCost(),
                            room1.getMaxNumberOfCustomer(),room1.getTypeRent(),room1.getFreeService()));
                }
            }
            csvPrinter.printRecord(Arrays.asList(room.getId(),room.getNameService(),room.getAreaUsed(),room.getRentalCost(),
                    room.getMaxNumberOfCustomer(),room.getTypeRent(),room.getFreeService()));
            csvPrinter.flush();
            System.out.println("Write csv file by using new Apache lib successfully");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Room> readCsvFile() {
        List<Room> oldRooms = new ArrayList<>();
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_ROOM));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_ROOM).withIgnoreHeaderCase().withTrim());

            int i = 0;
            for (CSVRecord csvRecord: csvParser){
                if (i == 0){
                    i++;
                }else {
                    Room room = new Room();
                    room.setId(csvRecord.get(0));
                    room.setNameService(csvRecord.get(1));
                    room.setAreaUsed(Double.parseDouble(csvRecord.get(2)));
                    room.setRentalCost(Double.parseDouble(csvRecord.get(3)));
                    room.setMaxNumberOfCustomer(Integer.parseInt(csvRecord.get(4)));
                    room.setTypeRent(csvRecord.get(5));
                    room.setFreeService(csvRecord.get(6));
                    oldRooms.add(room);
                }
            }
            return oldRooms;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public TreeSet<Room> readCsvFileNotDuplicate()  {
        TreeSet<Room> oldRoom = new TreeSet<>(new RoomCompare());
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(PATH_FILE_ROOM));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(FILE_HEADER_OF_ROOM).withIgnoreHeaderCase().withTrim());

            int i = 0;
            for (CSVRecord csvRecord: csvParser){
                if (i == 0){
                    i++;
                }else {
                    Room room = new Room();
                    room.setId(csvRecord.get(0));
                    room.setNameService(csvRecord.get(1));
                    room.setAreaUsed(Double.parseDouble(csvRecord.get(2)));
                    room.setRentalCost(Double.parseDouble(csvRecord.get(3)));
                    room.setMaxNumberOfCustomer(Integer.parseInt(csvRecord.get(4)));
                    room.setTypeRent(csvRecord.get(5));
                    room.setFreeService(csvRecord.get(6));
                    oldRoom.add(room);
                }
            }
            return oldRoom;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
