package com.codegym.entity.AccompaniedServices;

import javax.persistence.*;

@Entity
@Table(name = "accompanied_services")
public class AccompaniedServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accompanied_service_id")
    private Long accompanied_service_id;

    @Column(name = "accompanied_service_name")
    private String accompaniedServiceName;

    @Column(name = "price")
    private Double price;

    @Column(name = "unit")
    private String unit;

    public AccompaniedServices() {
    }

    public Long getAccompanied_service_id() {
        return accompanied_service_id;
    }

    public void setAccompanied_service_id(Long accompanied_service_id) {
        this.accompanied_service_id = accompanied_service_id;
    }

    public String getAccompaniedServiceName() {
        return accompaniedServiceName;
    }

    public void setAccompaniedServiceName(String accompaniedServiceName) {
        this.accompaniedServiceName = accompaniedServiceName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
