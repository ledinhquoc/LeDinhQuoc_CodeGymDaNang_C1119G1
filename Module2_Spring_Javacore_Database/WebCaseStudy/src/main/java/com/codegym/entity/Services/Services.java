package com.codegym.entity.Services;

import com.codegym.entity.Contracts.Contracts;
import com.codegym.entity.TypeRent.TypeRent;
import com.codegym.entity.TypeServices.TypeService;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "services")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long service_id;

    @Column(name = "service_name")
    private String service_name;

    @Column(name = "service_status")
    private String status;

    @Column(name = "area_used")
    private int area_used;

    @Column(name = "number_floors",columnDefinition = "Decimal(18,2) default '100.00'")
    private int number_floors;

    @Column(name = "number_max_people",columnDefinition = "Decimal(18,2) default '100.00'")
    private int number_max_people;

    @Column(name = "rental_costs")
    private Double rental_costs;


    @Column(name = "accompanied_service_status")
    private String accompanied_service_status;

    @ManyToOne
    @JoinColumn(name = "type_rent_id")
    private TypeRent typeRent;

    @ManyToOne
    @JoinColumn(name = "type_service_id")
    private TypeService typeService;

    @OneToMany(targetEntity = Contracts.class , mappedBy = "services", cascade = CascadeType.ALL)
    private List<Contracts> contracts;

    public Services() {
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getArea_used() {
        return area_used;
    }

    public void setArea_used(int area_used) {
        this.area_used = area_used;
    }

    public int getNumber_floors() {
        return number_floors;
    }

    public void setNumber_floors(int number_floors) {
        this.number_floors = number_floors;
    }

    public int getNumber_max_people() {
        return number_max_people;
    }

    public void setNumber_max_people(int number_max_people) {
        this.number_max_people = number_max_people;
    }

    public Double getRental_costs() {
        return rental_costs;
    }

    public void setRental_costs(Double rental_costs) {
        this.rental_costs = rental_costs;
    }

    public TypeRent getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(TypeRent typeRent) {
        this.typeRent = typeRent;
    }

    public TypeService getTypeService() {
        return typeService;
    }

    public void setTypeService(TypeService typeService) {
        this.typeService = typeService;
    }

    public List<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contracts> contracts) {
        this.contracts = contracts;
    }

    public String getAccompanied_service_status() {
        return accompanied_service_status;
    }

    public void setAccompanied_service_status(String accompanied_service_status) {
        this.accompanied_service_status = accompanied_service_status;
    }

}
