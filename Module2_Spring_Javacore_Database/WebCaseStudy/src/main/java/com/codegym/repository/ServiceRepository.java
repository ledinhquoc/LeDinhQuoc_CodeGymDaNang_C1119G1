package com.codegym.repository;

import com.codegym.entity.Services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Services,Long> {
@Query("select sv from Services  sv where sv.typeService.typeServiceName like %?1%")
    Page<Services> findAllWhereNameBeLike(String name, Pageable pageable);
    Page<Services> findAllByStatus(String status,Pageable pageable);
}
