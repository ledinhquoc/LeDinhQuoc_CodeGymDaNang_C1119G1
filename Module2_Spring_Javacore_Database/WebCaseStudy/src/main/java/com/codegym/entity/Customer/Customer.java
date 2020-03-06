package com.codegym.entity.Customer;

import com.codegym.entity.Contracts.Contracts;
import com.codegym.entity.TypeCustomer.TypeCustomers;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customer_id;

    @NotEmpty(message = "this value have to fill in")
    @Size(min = 2,max = 30 , message = "FullName have to fill between 2 and 30 characters")
    @Column(name = "full_name")
    private String fullName;


    @Column(name = "birthday")
    private Date birthday;

    @NotEmpty
    @Column(name = "id_card")
    private String id_card;

    @NotEmpty
    @Column(name = "phone_number")
    private String phone_number;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotEmpty
    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "type_customer_id")
    private TypeCustomers typeCustomer;

    @OneToMany(targetEntity = Contracts.class,mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Contracts> contracts;

    public Customer() {
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        if (this.birthday == null)
            return "";
            return  new SimpleDateFormat("dd/MM/yyyy").format(this.birthday);
    }

    public void setBirthday(String birthday) {

            try {
                this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            }catch (ParseException e){
                this.birthday = null;
            }
        }
    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public TypeCustomers getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomers typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public List<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contracts> contracts) {
        this.contracts = contracts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", id_card='" + id_card + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", typeCustomer=" + typeCustomer +
                ", contracts=" + contracts +
                '}';
    }
}
