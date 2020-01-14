package Ultils.Compare;

import Models.Villa;

import java.util.Comparator;

public class VillaCompare implements Comparator<Villa> {
    @Override
    public int compare(Villa o1,Villa o2){
        if (o1.getId().equals(o2.getId()) || o1.getNameService().equals(o2.getNameService())){
            return 0;
        }
        return 1;
    }

}
