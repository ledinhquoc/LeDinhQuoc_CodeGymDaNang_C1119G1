package service;

import models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;
    static {
        products= new HashMap<>();
        products.put(1, new Product(1,"Iphone","abc",200));
        products.put(2, new Product(2,"Iphone 1","b",300));
        products.put(3, new Product(3,"Iphone 2","c",400));
        products.put(4, new Product(4,"Iphone 3","d",500));
        products.put(5, new Product(5,"Iphone 4","e",600));
        products.put(6, new Product(6,"Iphone 5","f",700));
        products.put(7, new Product(7,"Iphone 6","g",800));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> productList=findAll();
        for (Product product:productList){
            if (product.getName().equals(name))
                return product;
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}