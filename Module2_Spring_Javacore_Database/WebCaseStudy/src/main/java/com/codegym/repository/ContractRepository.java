package com.codegym.repository;

import com.codegym.entity.Contracts.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contracts,Long> {
    //TODO findUnusedContracts
//    @Query("select ct from Contracts ct where ct.")
}
