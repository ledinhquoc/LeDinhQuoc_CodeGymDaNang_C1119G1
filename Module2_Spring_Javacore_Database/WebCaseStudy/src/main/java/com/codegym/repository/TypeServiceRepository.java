package com.codegym.repository;

import com.codegym.entity.TypeServices.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService,Long> {
    @Query("select ts from TypeService ts")
    List<TypeService>findAll();
}
