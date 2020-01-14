package Models;

public class Villa extends Service {
private String roomStandard;
private String otherServiceDescription;
private double poolArea;
private int numberOfFloor;

    public Villa(String id, String nameService, double areaUsed, double rentalCost, int maxNumberOfCustomer,
                 String typeRent, String roomStandard, String otherServiceDescription, double poolArea, int numberOfFloor) {
        super(id, nameService, areaUsed, rentalCost, maxNumberOfCustomer, typeRent);
        this.roomStandard = roomStandard;
        this.otherServiceDescription = otherServiceDescription;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa() {
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String showInfor(){
        return  "1. Id Service: " + super.getId() +
                "\n\t2. Name Service: " + super.getNameService() +
                "\n\t3. areaUsed: " + super.getAreaUsed() +
                "\n\t4. rentalCost: " + super.getRentalCost() +
                "\n\t5. maxNumberOfCustomer: " + super.getMaxNumberOfCustomer() +
                "\n\t6. typeRent: " + super.getTypeRent() +
                "\n\t7. roomStandard: " + this.getRoomStandard() +
                "\n\t8.otherServiceDescription: " + this.getOtherServiceDescription() +
                "\n\t9. poolArea: " + this.getPoolArea() +
                "\n\t10. numberOfFloor: " + this.getNumberOfFloor();
    }
}
