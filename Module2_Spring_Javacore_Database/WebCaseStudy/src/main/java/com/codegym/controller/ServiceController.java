package com.codegym.controller;

import com.codegym.entity.AccompaniedServices.AccompaniedServices;
import com.codegym.entity.Contracts.Contracts;
import com.codegym.entity.Customer.Customer;
import com.codegym.entity.Employee.Employee;
import com.codegym.entity.Services.Services;
import com.codegym.entity.TypeCustomer.TypeCustomers;
import com.codegym.entity.TypeRent.TypeRent;
import com.codegym.entity.TypeServices.TypeService;
import com.codegym.entity.comment.Comment;
import com.codegym.repository.*;
import com.codegym.security.User;
import com.codegym.services.*;
import com.codegym.validator.ServiceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ServiceController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRipository customerRipository;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private RentTypeRipository rentTypeRipository;
    @Autowired
    private TypeServiceRepository typeServiceRepository;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailsRepository contractDetailsRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private AccompaniedServiceRepository accompaniedServiceRepository;
    @Autowired
    private commentRepository commentRepository;
    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @ModelAttribute("employees")
    private Page< Employee > employees(Pageable pageable) {
        return employeeService.findAll (pageable);
    }

    @ModelAttribute("accompanied_services")
    private List< AccompaniedServices > accompaniedServices() {
        return accompaniedServiceRepository.finAllAser ();
    }

    @ModelAttribute("contracts")
    private Page< Contracts > contracts(Pageable pageable) {
        return contractService.findAll (pageable);
    }

    @ModelAttribute("type_customers")
    private List< TypeCustomers > customerTypes() {
        return typeCustomerRepository.getAll ();
    }

    @ModelAttribute("customers")
    private List< Customer > customers() {
        return customerService.findAll ();
    }

    @ModelAttribute("rentTypes")
    private List< TypeRent > rentTypes() {
        return rentTypeRipository.findAll ();
    }

    @ModelAttribute("serviceTypes")
    private List< TypeService > serviceTypes() {
        return typeServiceRepository.findAll ();
    }

    @ModelAttribute("services")
    private Page< Services > services(Pageable pageable) {
        return serviceService.findAll (pageable);
    }

    @ModelAttribute("favServices")
    private List< Services > favServices() {
        return new ArrayList<> ();
    }

    @ModelAttribute("currentUser")
    private User setUpUser() {
        return new User ();
    }

    @GetMapping("/service")
    public String handleServicePage(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            @RequestParam(name = "sortValue", required = false, defaultValue = "area") String sortValue,
            Model model, Pageable pageable, Sort sortable
    ) {
        if (sort.equals ("ASC")) {
            if (sortable.isSorted ()) {
                sortable = Sort.by (sortValue).descending ();
            } else {
                sortable = Sort.by (sortValue).ascending ();
            }
        }
        if (sort.equals ("DESC")) {
            if (sortable.isSorted ()) {
                sortable = Sort.by (sortValue).ascending ();
            } else {
                sortable = Sort.by (sortValue).descending ();
            }
        }
        pageable = PageRequest.of (page, size, sortable);
        model.addAttribute ("services", serviceService.findAll (pageable));
        return "service/list";
    }

    @GetMapping("/service/create")
    public ModelAndView handleNewService() {
        return new ModelAndView ("service/new", "service", new Services ());
    }

    @PostMapping("/service/create")
    public String handleSaveService(@Valid Services services,
                                    RedirectAttributes redirectAttributes,
                                    BindingResult result
    ) {
        new ServiceValidator ().validate (services, result);
        if (result.hasFieldErrors ()) return "list";
        serviceService.save (services);
        redirectAttributes.addFlashAttribute ("status", "Added successfully!");
        return "redirect:/service";
    }

    @GetMapping("/service/{id}/edit")
    public ModelAndView handleUpdateService(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView ("service/edit", "service", serviceService.findById (id));
        return mav;
    }

    @PostMapping("/service/edit")
    public String handleUpdateService(@Valid Services services,
                                      RedirectAttributes redirectAttributes,
                                      BindingResult result
    ) {
        new ServiceValidator ().validate (services, result);
        if (result.hasFieldErrors ()) {
            return "service/edit";
        }
        serviceService.save (services);
        redirectAttributes.addFlashAttribute ("status", "Updated successfully!");
        return "redirect:/service";
    }

    @PostMapping("/service/{id}/delete")
    public String handleDeleteService(@RequestParam String confirm,
                                      RedirectAttributes redirectAttributes,
                                      @PathVariable Long id) {
        if (confirm.equals ("yes")) {
            serviceService.remove (id);
            redirectAttributes.addFlashAttribute ("status", "Deleted successfully!");
        }
        System.out.printf ("Service id:{%d}", id);
        return "redirect:/service";
    }

    @GetMapping("/service/{id}/delete")
    public String handleDeleteService(@PathVariable Long id,
                                      Model model) {
        model.addAttribute ("serviceId", id);
        return "service/delete-confirm";

    }

    @GetMapping("/comment")
    public String getComment(Model model) {
        model.addAttribute ("comment", new Comment ());
        model.addAttribute ("comments", commentRepository.findAll ());
        return "comment-page";
    }

    @PostMapping("/comment-post")
    public String handlePostComment(Comment comment) {
        commentRepository.save (comment);
        return "redirect:/comment";
    }

    @GetMapping("/service-search")
    public String handleServiceSearch(@RequestParam("serviceStatus") String status,
                                      Pageable pageable,
                                      Model model) {
        pageable = PageRequest.of (0, 5);
        model.addAttribute ("services", serviceService.findAllByStatus (status, pageable));
        return "service/list";
    }

    @GetMapping("/like-service/{id}")
    public String handleLikeService(@PathVariable Long id,
                                    @ModelAttribute("favServices") List< Services > Services,
                                    RedirectAttributes redirectAttributes) {
        Services.add (serviceService.findById (id));
        redirectAttributes.addFlashAttribute ("status", "Added to collections!");
        return "redirect:/service";
    }
}

