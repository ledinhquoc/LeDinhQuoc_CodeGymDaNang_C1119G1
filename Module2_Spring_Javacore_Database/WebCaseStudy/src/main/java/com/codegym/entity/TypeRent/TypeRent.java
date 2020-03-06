package com.codegym.entity.TypeRent;

import com.codegym.entity.Services.Services;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_rents")
public class TypeRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_rent_id")
    private Long type_rent_id;

    @Column(name = "type_rent_name")
    private String typeRentName;

    @OneToMany(targetEntity = Services.class, mappedBy = "typeRent", cascade = CascadeType.ALL)
    private List<Services> services;

    public TypeRent() {
    }

    public Long getType_rent_id() {
        return type_rent_id;
    }

    public void setType_rent_id(Long type_rent_id) {
        this.type_rent_id = type_rent_id;
    }

    public String getTypeRentName() {
        return typeRentName;
    }

    public void setTypeRentName(String typeRentName) {
        this.typeRentName = typeRentName;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
}
