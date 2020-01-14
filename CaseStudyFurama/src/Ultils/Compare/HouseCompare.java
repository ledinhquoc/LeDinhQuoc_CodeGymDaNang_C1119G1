package Ultils.Compare;

import Models.House;

import java.util.Comparator;

public class HouseCompare implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        if (o1.getId().equals(o2.getId()) || o1.getNameService().equals(o2.getNameService())){
            return 0;
        }
        return 1;
    }
}
