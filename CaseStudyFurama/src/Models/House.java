package Models;

public class House extends Service {
    private String roomStandard;
    private String otherServiceDescription;
    private int numberOfFloor;

    public House() {
    }

    public House(String id, String nameService, double areaUsed, double rentalCost, int maxNumberOfCustomer, String typeRent,
                 String roomStandard, String otherServiceDescription, int numberOfFloor) {
        super(id, nameService, areaUsed, rentalCost, maxNumberOfCustomer, typeRent);
        this.roomStandard = roomStandard;
        this.otherServiceDescription = otherServiceDescription;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherServiceDescription() {
        return otherServiceDescription;
    }

    public void setOtherServiceDescription(String otherServiceDescription) {
        this.otherServiceDescription = otherServiceDescription;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }
    @Override
    public String showInfor(){
        return  "\t1. Id Service: " + super.getId() +
                "\n\t2. Name Service: " + super.getNameService() +
                "\n\t3. areaUsed: " + super.getAreaUsed() +
                "\n\t4. rentalCost: " + super.getRentalCost() +
                "\n\t5. maxNumberOfCustomer: " + super.getMaxNumberOfCustomer() +
                "\n\t6. typeRent: " + super.getTypeRent() +
                "\n\t7. roomStandard: " + this.getRoomStandard() +
                "\n\t8. otherServiceDescription: " + this.getOtherServiceDescription() +
                "\n\t9. numberOfFloor: " + this.getNumberOfFloor();
    }
}
