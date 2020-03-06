package com.codegym.entity.TypeCustomer;

import com.codegym.entity.Customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_customers")
public class TypeCustomers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_customer_id")
    private Long type_customer_id;

    @Column(name = "type_customer_name")
    private String type_customer_name;

    @OneToMany(targetEntity = Customer.class, mappedBy = "typeCustomer", cascade = CascadeType.ALL )
    private List<Customer> customers;

    public TypeCustomers() {
    }

    public Long getType_customer_id() {
        return type_customer_id;
    }

    public void setType_customer_id(Long type_customer_id) {
        this.type_customer_id = type_customer_id;
    }

    public String getType_customer_name() {
        return type_customer_name;
    }

    public void setType_customer_name(String type_customer_name) {
        this.type_customer_name = type_customer_name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
