package com.codegym.baitap_giohang.reponsitory;

import com.codegym.baitap_giohang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductReponsitory extends JpaRepository<Product,Long> {

    @Query("select c from Product c where c.id=?1")
    Product findByIdNew(Long id);

    @Query("select c from Product c")
    List<Product> getAllProducts();

}
