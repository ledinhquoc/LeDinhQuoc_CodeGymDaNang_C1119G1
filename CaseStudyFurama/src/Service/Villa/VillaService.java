package Service.Villa;

import Models.Villa;
import Repository.FuncWriteAndReadCSV;

public interface VillaService extends FuncWriteAndReadCSV<Villa> {
    void addNewVilla();
    void showAllVilla();
    Villa getVillaById (int id);
    void showAllVillaNotDuplicate();
}
