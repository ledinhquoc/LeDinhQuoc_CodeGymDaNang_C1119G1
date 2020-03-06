package com.codegym.entity.Contracts;

import com.codegym.entity.ContractDetails.ContractDetails;
import com.codegym.entity.Customer.Customer;
import com.codegym.entity.Employee.Employee;
import com.codegym.entity.Services.Services;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contracts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long contract_id;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "contract_date")
    private Date contract_date;

    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private  Date contract_date_end;


    @Column(name = "deposit")
    private Long deposit;

    @Column(name = "total")
    private Long total;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Services services;

    @OneToMany(targetEntity = ContractDetails.class,mappedBy = "contracts",cascade = CascadeType.ALL)
    private List<ContractDetails> contractDetails;

    public Contracts() {
    }

    public Long getContract_id() {
        return contract_id;
    }

    public void setContract_id(Long contract_id) {
        this.contract_id = contract_id;
    }

    public String getContract_date() {
        if (this.contract_date == null)
            return "";
        return new SimpleDateFormat ("dd/MM/yyyy").format (this.contract_date);
    }

    public void setContract_date(String contract_date) throws ParseException
    {
        try {
            this.contract_date = new SimpleDateFormat ("yyyy/MM/dd").parse (contract_date);
        }catch (ParseException e){
            this.contract_date = null;
        }
    }

    public String getContract_date_end() {
        if (this.contract_date_end == null)
            return "";
        return new SimpleDateFormat ("dd/MM/yyyy").format (this.contract_date_end);
    }

    public void setContract_date_end(String contract_date_end) throws ParseException
    {
        try {
            this.contract_date_end = new SimpleDateFormat ("yyyy/MM/dd").parse (contract_date_end);
        }catch (ParseException e){
            this.contract_date_end = null;
        }
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee_id() {
        return employee_id;
    }

    public void setEmployee(Employee employee_id) {
        this.employee_id = employee_id;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public List<ContractDetails> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetails> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
