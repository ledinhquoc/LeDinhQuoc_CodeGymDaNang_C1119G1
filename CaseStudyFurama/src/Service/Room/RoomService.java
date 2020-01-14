package Service.Room;

import Models.Room;
import Repository.FuncWriteAndReadCSV;

public interface RoomService extends FuncWriteAndReadCSV<Room> {
        void addNewRoom();
        void showAllRoom();
        Room getRoomById(int id);

    void showAllRoomNotDuplicate();
}
