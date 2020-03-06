package com.codegym.repository;

import com.codegym.entity.TypeRent.TypeRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentTypeRipository extends JpaRepository<TypeRent,Long> {
    @Query("select tr from TypeRent  tr")
    List<TypeRent>findAll();
}
