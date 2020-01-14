package Models;

public abstract class Service {
    private String id;
    private String nameService;
    private double areaUsed;
    private double rentalCost;
    private int maxNumberOfCustomer;
    private String typeRent;

    public Service(String id, String nameService, double areaUsed, double rentalCost, int maxNumberOfCustomer, String typeRent) {
        this.id = id;
        this.nameService = nameService;
        this.areaUsed = areaUsed;
        this.rentalCost = rentalCost;
        this.maxNumberOfCustomer = maxNumberOfCustomer;
        this.typeRent = typeRent;
    }

    public Service() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(double areaUsed) {
        this.areaUsed = areaUsed;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNumberOfCustomer() {
        return maxNumberOfCustomer;
    }

    public void setMaxNumberOfCustomer(int maxNumberOfCustomer) {
        this.maxNumberOfCustomer = maxNumberOfCustomer;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }
public abstract String showInfor();
}
