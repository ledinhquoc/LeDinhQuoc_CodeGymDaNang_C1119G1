package com.codegym.entity.ContractDetails;

import com.codegym.entity.AccompaniedServices.AccompaniedServices;
import com.codegym.entity.Contracts.Contracts;

import javax.persistence.*;

@Entity
@Table(name = "contract_details")
public class ContractDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_detail_id")
    private Long contract_detail_id;

    @Column(name = "quantity")
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contracts contracts;

    @ManyToOne
    @JoinColumn(name = "accompanied_service_id")
    private AccompaniedServices accompanied_service;

    public ContractDetails() {
    }

    public Long getContract_detail_id() {
        return contract_detail_id;
    }

    public void setContract_detail_id(Long contract_detail_id) {
        this.contract_detail_id = contract_detail_id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Contracts getContracts() {
        return contracts;
    }

    public void setContracts(Contracts contracts) {
        this.contracts = contracts;
    }

    public AccompaniedServices getAccompanied_service() {
        return accompanied_service;
    }

    public void setAccompanied_service(AccompaniedServices accompanied_service) {
        this.accompanied_service = accompanied_service;
    }
}
