package Models;

public class Room extends Service {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double areaUsed, double rentalCost, int maxNumberOfCustomer, String typeRent, String freeService) {
        super(id, nameService, areaUsed, rentalCost, maxNumberOfCustomer, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }
    @Override
    public String showInfor(){
        return  "\t1. ID: " + super.getId() +
                "\n\t1. Name Service: " + super.getNameService() +
                "\n\t2. areaUsed: " + super.getAreaUsed() +
                "\n\t3. rentalCost: " + super.getRentalCost() +
                "\n\t4. maxNumberOfCustomer: " + super.getMaxNumberOfCustomer() +
                "\n\t5. typeRent: " + super.getTypeRent() +
                "\n\t6. freeService: " + this.getFreeService();
    }
}
