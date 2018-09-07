package com.itvilla.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itvilla.springdemo.entity.Customer;
import com.itvilla.springdemo.service.CustomerService;

@RestController
@RequestMapping("/itvillaapi")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}

	@GetMapping("/customers/{custId}")
	public Customer getCustomer(@PathVariable int custId) {
		
		Customer Customer = customerService.getCustomer(custId);
		
		return Customer;
	}

	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer myCustomer) {
		myCustomer.setId(0);
		customerService.saveCustomer(myCustomer);
		return myCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer myCustomer) {
		
		customerService.saveCustomer(myCustomer);
		
		return myCustomer;
		
	}
	
	
	@DeleteMapping("/customers/{custId}")
	public String deleteCustomer(@PathVariable int custId) {
		Customer tempCustomer = customerService.getCustomer(custId);
		
			customerService.deleteCustomer(custId);
		
		return "Successfully deleted the customer with ID  :  " + custId;
	}
	
	
}












