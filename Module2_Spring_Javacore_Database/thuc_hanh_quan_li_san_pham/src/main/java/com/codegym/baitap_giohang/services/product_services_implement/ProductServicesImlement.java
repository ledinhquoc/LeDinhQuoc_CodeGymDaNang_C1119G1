package com.codegym.baitap_giohang.services.product_services_implement;

import com.codegym.baitap_giohang.model.Product;
import com.codegym.baitap_giohang.reponsitory.ProductReponsitory;
import com.codegym.baitap_giohang.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class ProductServicesImlement implements ProductService {

    @Autowired
    ProductReponsitory reponsitory;



    @Override
    public List<Product> getAllProducts() {
        return reponsitory.getAllProducts();
    }

    @Override
    public void save(Product product) {
        reponsitory.save(product);
    }

    @Override
    public void delete(Long id) {
        reponsitory.deleteById(id);
    }

    @Override
    public Product findByIdNew(Long id) {
        return reponsitory.findByIdNew(id);
    }

//    @Override
//    public Product findById(Long id) {
//        return reponsitory.findById(id);
//    }


}
