package com.codegym.controller;


import com.codegym.entity.Contracts.Contracts;
import com.codegym.entity.Customer.Customer;
import com.codegym.entity.Employee.Employee;
import com.codegym.entity.Services.Services;
import com.codegym.services.ContractService;
import com.codegym.services.CustomerService;
import com.codegym.services.EmployeeService;
import com.codegym.services.ServiceService;
import com.codegym.validator.ContractValidator;
import com.codegym.validator.ServiceValidator;
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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;


@Controller
public class ContractController {
    @Autowired
    ContractService contractService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ServiceService serviceService;

    @ModelAttribute(name = "employees")
    public Page< Employee > employees(Pageable pageable){
        return employeeService.findAll (pageable);
    }
    @ModelAttribute(name = "services")
    public Page< Services > services(Pageable pageable){
        return serviceService.findAll (pageable);
    }
    @ModelAttribute("customers")
    public Page< Customer > customers(Pageable pageable){
        return customerService.findAll (pageable);
    }

    @GetMapping("/contract")
        public String getAllContract(@PageableDefault(value = 5) Pageable pageable,
                                     @RequestParam(name = "page", required = false,defaultValue = "0")int page,
                                     @RequestParam(name = "size",required = false,defaultValue = "3")int size,
                                     @RequestParam(name = "sort",required = false,defaultValue = "ASC")String sort,
                                     @RequestParam(name = "sortValue",required = false,defaultValue = "contract_date")String sortValue,
                                     Model model, Sort sortable){
        if(sort.equals("ASC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).descending();
            }
            else{
                sortable=Sort.by(sortValue).ascending();
            }
        }
        if(sort.equals("DESC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).ascending();
            }
            else{
                sortable=Sort.by(sortValue).descending();
            }
        }
        pageable= PageRequest.of(page, size,sortable);
            model.addAttribute ("contracts",contractService.findAll (pageable));
            return"contract/list";
    }
    @GetMapping("/contract/create")
    public ModelAndView createContract(){
        return new ModelAndView ("contract/create","contract",new Contracts ());
    }

    @PostMapping("/contract/create")
    public String createContract(@Valid Contracts contracts,
                                 BindingResult bindingResult,
                                 HttpServletResponse response,
                                 @CookieValue(value = "dateCreated",defaultValue = "")String dateCreated)
    {
        new ContractValidator ().validate (contracts,bindingResult);
        if (bindingResult.hasFieldErrors ()) return "/contract/create";
        contractService.save (contracts);

        LocalDate date =LocalDate.now ();
        dateCreated += "#"+date.toString ();
        Cookie cookie = new Cookie ("dateCreated",dateCreated);
        cookie.setMaxAge (3*24*60*60);
        cookie.setPath ("/");
        response.addCookie (cookie);
        return "redirect:/";
    }




}
