package com.codegym.baitap_giohang.services;

import com.codegym.baitap_giohang.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void save(Product product);
    void delete(Long id);
    Product findByIdNew(Long id);

}
