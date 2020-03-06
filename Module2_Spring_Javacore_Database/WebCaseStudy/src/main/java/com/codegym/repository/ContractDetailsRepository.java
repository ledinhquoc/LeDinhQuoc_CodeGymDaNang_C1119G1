package com.codegym.repository;

import com.codegym.entity.ContractDetails.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailsRepository extends JpaRepository<ContractDetails,Long> {
    @Query("select cd from ContractDetails cd ")
    List<ContractDetails> findAllCd();
}
