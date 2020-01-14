package Ultils.Compare;

import Models.Room;

import java.util.Comparator;

public class RoomCompare implements Comparator<Room> {
    @Override
    public int compare(Room o1, Room o2) {
        if (o1.getId().equals(o2.getId()) || o1.getNameService().equals(o2.getNameService())){
            return 0;
        }
        return 1;
    }
}
