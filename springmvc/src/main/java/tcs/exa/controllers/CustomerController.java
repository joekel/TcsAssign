package tcs.exa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tcs.exa.domain.Customer;
import tcs.exa.services.CustomerService;


@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String listCustomers(Model model){
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{id}")
    public String showCustomer(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/show";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("customer", customerService.getById(id));
        return "customer/customerform";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer){
    	  customerService.saveOrUpdate(customer);
        return "redirect:customer/" ;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.delete(id);
        return "redirect:/customer/list";
    }
}
