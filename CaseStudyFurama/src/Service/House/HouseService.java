package Service.House;

import Models.House;
import Repository.FuncWriteAndReadCSV;

import java.util.Set;

public interface HouseService extends FuncWriteAndReadCSV<House> {
    void addNewHouse();
    void showAllHouse();

    void showAllHouseNotDuplicate();

    House getHouseById(int serviceId);


}
