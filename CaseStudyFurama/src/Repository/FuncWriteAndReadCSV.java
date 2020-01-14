package Repository;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public interface FuncWriteAndReadCSV<Q> {
    Set<String> getNameServiceFromFileCSV(String path);
     void writeCsvFile(Q q);
    List<Q> readCsvFile();
    TreeSet<Q> readCsvFileNotDuplicate();

}







