package com.example.HoteldB.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.HoteldB.entity.Bill;
import com.example.HoteldB.entity.Category;
import com.example.HoteldB.entity.Customer;
import com.example.HoteldB.entity.CustomerForm;
import com.example.HoteldB.entity.OrderItem;
import com.example.HoteldB.entity.OrderItemsOfCustomers;
import com.example.HoteldB.exceptions.CustomerNotFoundException;
import com.example.HoteldB.exceptions.FieldWithNullValueException;

import com.example.HoteldB.model.CustomerCrudOperations;
import com.example.HoteldB.model.OrderCrudOperations;
import com.example.HoteldB.service.CustomerService;
import com.example.HoteldB.service.OrderService;

@RestController
public class ApiController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	OrderService operations;
	@GetMapping("/api")
	private Map<Category, List<String>> home() {
//		operations.addOrderItem(new OrderItem("chicken",Category.NonVeg,122));
		return operations.getAllOrderItems();
	}
	@GetMapping("/api/currentCustomers")
	private List<Customer> getCurrentCustomers() {
		return customerService.getCurrentCustomers();
	}
	
	@PostMapping(path = "/api/addCustomer",consumes = "application/json")
	private String saveCustomer(@RequestBody final CustomerForm form) throws FieldWithNullValueException
	{
		if(customerService.addCustomer(form))
			return "saved";
		return "All form values are Compulsory";
	}
	@GetMapping("/api/getCustomerById/{id}")
	private Object getCustomerById(@PathVariable final int id) {
			Customer cust = new Customer();
			cust=customerService.getCustomerById(id);
			if(cust != null)
				return cust;
			else
				return "Invalid id";
			
	}
	@GetMapping("/api/getCustomerByTable/{tableNo}")
	private Object getCustomerByTable(@PathVariable final int tableNo)
	{
		Customer cust=new Customer();
		cust=customerService.getCustomerByTable(tableNo);
		if(cust==null)
			return new CustomerNotFoundException("Customer not found").getMessage();
		return cust;
	}
	
	@GetMapping("/api/updateOrder/{id}/{orderForm}")
	private String updateOrder(@PathVariable("id") int id,@PathVariable("orderForm") List<OrderItemsOfCustomers> form) throws CustomerNotFoundException
	{
		customerService.addOrder(id,form);
		return "updated";
	}
	
	@GetMapping("/api/allCustomers")
	private List<Customer> getAllCustomers() {
		return (List<Customer>) customerService.getAllOldCustomers();
	}
}
