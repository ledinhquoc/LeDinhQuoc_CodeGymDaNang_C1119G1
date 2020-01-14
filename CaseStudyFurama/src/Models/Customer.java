package Models;

public class Customer {
    private String id;
    private String name;
    private String birthday;
    private String gender;
    private String idCard;
    private String phone;
    private String email;
    private String customerType;
    private String address;
    private Service useService;
    private String idService;

    public int getYearBirthday;

    public Customer() {
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public Customer(String id, String name, String birthday, String gender, String idCard, String phone, String email, String customerType, String address, Service useService) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
        this.address = address;
        this.useService = useService;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getUseService() {
        return useService;
    }

    public void setUseService(Service useService) {
        this.useService = useService;
    }

    public String showInfo(){
        return "\t1.ID:" + this.getId()
                + "\n\t2. Name:" + this.getName()
                + "\n\t3. birthday:" + this.getBirthday()
                + "\n\t4. gender:" + this.getGender()
                + "\n\t5. idCard:" + this.getIdCard()
                + "\n\t6. phone:" + this.getPhone()
                + "\n\t7. email:" + this.getEmail()
                + "\n\t8. customer type:" + this.getCustomerType()
                + "\n\t9. address:" + this.getAddress()
                + "\n\t10. use service:" + getIdService();
    }
    public int getYearBirthday(){
        String temp = "";
        for (int i = birthday.length() - 4; i < birthday.length();i++){
            temp +=birthday.charAt(i);
        }
        return Integer.valueOf(temp);
    }
}
