package com.codegym.entity.TypeServices;

import com.codegym.entity.Services.Services;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_services")
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_service_id")
    private Long type_service_id;

    @Column(name = "type_service_name")
    private String typeServiceName;

    @OneToMany(targetEntity = Services.class, mappedBy = "typeService", cascade = CascadeType.ALL)
    private List<Services> services;

    public TypeService() {
    }

    public Long getType_service_id() {
        return type_service_id;
    }

    public void setType_service_id(Long type_service_id) {
        this.type_service_id = type_service_id;
    }

    public String getTypeServiceName() {
        return typeServiceName;
    }

    public void setTypeServiceName(String typeServiceName) {
        this.typeServiceName = typeServiceName;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
}
