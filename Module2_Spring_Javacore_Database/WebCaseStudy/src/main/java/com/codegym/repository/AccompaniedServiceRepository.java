package com.codegym.repository;

import com.codegym.entity.AccompaniedServices.AccompaniedServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccompaniedServiceRepository extends JpaRepository<AccompaniedServices,Long> {
        @Query("select aser from AccompaniedServices aser ")
    List<AccompaniedServices> finAllAser();
}
