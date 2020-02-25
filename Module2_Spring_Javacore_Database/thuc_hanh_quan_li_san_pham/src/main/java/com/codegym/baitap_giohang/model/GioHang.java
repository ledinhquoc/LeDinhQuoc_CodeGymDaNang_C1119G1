package com.codegym.baitap_giohang.model;


import java.util.ArrayList;
import java.util.List;

public class GioHang {
    private List<Product> productList;

    public GioHang() {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void delete(Long id) {
        for (Product product : productList
        ) {
            if (product.getId() == id) {
                productList.remove(product);
                return;
            }
        }
    }


}
