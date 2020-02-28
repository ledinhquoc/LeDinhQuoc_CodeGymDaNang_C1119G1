package com.codegym.baitap_giohang.controller;


import com.codegym.baitap_giohang.model.GioHang;
import com.codegym.baitap_giohang.model.Product;
import com.codegym.baitap_giohang.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ProductController {

   @Autowired
    ProductService productService;



    @RequestMapping(value = "/product",method = RequestMethod.GET)
    public ResponseEntity<List<Product>> home( ) {
        List<Product> list = productService.getAllProducts();
        if (list.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND)
        }
        return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
    }

    @PostMapping("/product/add")
    public ResponseEntity<Void> add(@RequestBody Product product, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Customer " + product.getProductName());
        productService.save(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping("/product/save")
    public String saveProduct(Product product, RedirectAttributes redirect){
        product.setId((long) (Math.random()*100));
        productService.save(product);
        redirect.addFlashAttribute("success","Add new product success");
        return "redirect:/";
    }

    @RequestMapping("/product/{id}/edit")
    public String edit(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("productE",productService.findByIdNew(id));
        return "edit";
    }

    @RequestMapping("/product/{id}/view")
    public String view(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("productV",productService.findByIdNew(id));
        return "view_product";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Customer with id " + id);

        Product product = productService.findByIdNew(id);
        if (product == null) {
            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productService.delete(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }





}
