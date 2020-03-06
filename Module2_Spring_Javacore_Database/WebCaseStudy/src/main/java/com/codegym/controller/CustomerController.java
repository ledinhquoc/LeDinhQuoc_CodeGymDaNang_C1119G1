package com.codegym.controller;

import com.codegym.entity.Customer.Customer;
import com.codegym.entity.TypeCustomer.TypeCustomers;
import com.codegym.services.CustomerService;
import com.codegym.services.TypeCustomerService;
import com.codegym.untils.LocalDateFormatter;
import com.codegym.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController{
    @Autowired
    CustomerService customerService;
    @Autowired
    TypeCustomerService typeCustomerService;

    @ModelAttribute("typeCustomer")
    public Iterable< TypeCustomers > typeCustomers(){
        return typeCustomerService.findAll();
    }

    @Autowired
    LocalDateFormatter localDateFormatter;

    @GetMapping("/customer")
    public ModelAndView getAllCustomer(@PageableDefault(value = 5) Pageable pageable,
                                       @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                                       @RequestParam(name = "name") Optional< String > name, Model model,
                                       @RequestParam(name = "size", required = false, defaultValue = "5") int size,
                                       @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                       @RequestParam(name = "sortValue", required = false, defaultValue = "fullName") String sortValue,
                                       Sort sortable){
        Page< Customer > customerList;
        if(name.isPresent()){
            customerList = customerService.findAllWhereNameBeLike(name.get(), pageable);
            model.addAttribute("name", name.get());
        }else{
            customerList = customerService.findAll(pageable);
        }

        if(sort.equals("ASC")){
            if(sortable.isSorted()){
                sortable = Sort.by(sortValue).descending();
            }else{
                sortable = Sort.by(sortValue).ascending();
            }
        }
        if(sort.equals("DESC")){
            if(sortable.isSorted()){
                sortable = Sort.by(sortValue).ascending();
            }else{
                sortable = Sort.by(sortValue).descending();
            }
        }
        pageable = PageRequest.of(page, size, sortable);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("listCustomer", customerList);
        return modelAndView;
    }

    @GetMapping({"/customer/create"})
    public String create(Model model){
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/customer/create")
    public String createCustomer(@Valid @ModelAttribute(name = "customer") Customer customer, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){

        new CustomerValidator().validate(customer, bindingResult);
        if(bindingResult.hasErrors()){
            return ("/customer/create");
        }else{
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("message", "add information successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/{id}/edit")
    public String editCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("customer/edit")
    public String editCustomer(@Valid Customer customer,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        new CustomerValidator().validate(customer, bindingResult);
        if(bindingResult.hasFieldErrors()) return "customer/edit";
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Your information have been saved");
        return "redirect:/customer";
    }

    @GetMapping("customer/{id}/delete")
    public String deleteCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer_id", id);
        return "customer/deleteConfirm";
    }

    @PostMapping("customer/{id}/delete")
    public String deleteCustomer(@RequestParam String confirm,
                                 RedirectAttributes attributes,
                                 @PathVariable Long id){
        if(confirm.equals("yes")){
            customerService.remove(id);
            attributes.addFlashAttribute("message", "your information have been deleted");
        }
        return "redirect:/customer";
    }

    @GetMapping("/customer-search")
    public String CustomerSearch(@RequestParam("full_name") String fullName,
                                 Pageable pageable, Model model){
        pageable = PageRequest.of(0, 5);
        model.addAttribute("customers", customerService.findAllWhereNameBeLike(fullName, pageable));
        return "customer/list";
    }

    @GetMapping("/customer-using-service")
    public ModelAndView handleCustomerUsingContract(Pageable pageable,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam(defaultValue = "5") int size){
        pageable = PageRequest.of(page, size);
        return new ModelAndView("customer/customerUsingService",
                "customers", customerService.findCustomerUsedService(pageable));
    }


}
