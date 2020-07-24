package com.example.HoteldB.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.HoteldB.entity.Category;
import com.example.HoteldB.entity.Customer;
import com.example.HoteldB.entity.CustomerForm;
import com.example.HoteldB.entity.OrderItem;
import com.example.HoteldB.entity.OrderItemsOfCustomers;
import com.example.HoteldB.exceptions.FieldWithNullValueException;
import com.example.HoteldB.model.CustomerCrudOperations;
import com.example.HoteldB.service.CustomerService;
import com.example.HoteldB.service.OrderService;

import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
@Controller
public class CustomerViewController {

	@Autowired
	CustomerService customerService = new CustomerService();
	@Autowired
	OrderService orderService = new OrderService();
	
	@RequestMapping("/")
	public String getNewCustomerForm(Model model)
	{
//		orderService.addOrderItem(new OrderItem("Chicken Curry", Category.NonVeg, 120));
//		orderService.addOrderItem(new OrderItem("Paneer Masala", Category.Veg, 100));
//		orderService.addOrderItem(new OrderItem("Edd Curry", Category.NonVeg, 80));
//		orderService.addOrderItem(new OrderItem("Chicken Handi", Category.NonVeg, 620));
//		orderService.addOrderItem(new OrderItem("Chapati", Category.Breads, 12));
//		orderService.addOrderItem(new OrderItem("Bhakri", Category.Breads, 15));
//		orderService.addOrderItem(new OrderItem("Baingan Masala", Category.Veg, 80));
//		orderService.addOrderItem(new OrderItem("Cocola", Category.Coldrinks, 20));
//		orderService.addOrderItem(new OrderItem("Fanta", Category.Coldrinks, 20));

		customerService.initializeTableCount();
		return "customer/index";
		
	}
	@RequestMapping(path="/addCustomer" ,method=RequestMethod.GET)
    public String addCustomer(@ModelAttribute("userFormData") CustomerForm form,BindingResult result,RedirectAttributes redirectAttributes) throws FieldWithNullValueException {
	if(customerService.addCustomer(form));
        {
	        redirectAttributes.addAttribute("tableNo", form.getTable());
	        return "redirect:/addOrderTemplate";
        }
    }
	@RequestMapping("/allCustomers")
	public ModelAndView allCustomers(ModelAndView model)
	{
		//System.out.println(customerService.getAllCustomers());
		model.addObject("customers",customerService.getAllOldCustomers());
		model.setViewName("customer/allCurrentCustomers");
		return model;
	}
	@RequestMapping("/currentCustomers")
	public ModelAndView currentCustomers(ModelAndView model)
	{
		//System.out.println(customerService.getAllCustomers());
		model.addObject("customers",customerService.getCurrentCustomers());
		model.setViewName("customer/allCurrentCustomers");
		return model;
	}
	@RequestMapping(path="/getCustomerById",method=RequestMethod.GET)
	public ModelAndView getCustomerById(@RequestParam("id") int id,ModelAndView model)
	{
		model.addObject("customer", customerService.getCustomerById(id));
		model.addObject("flag", "customer");
		model.setViewName("customer/customer");
		return model;
	}
	@RequestMapping(path="/createBill",method=RequestMethod.POST)
	public ModelAndView createBill(HttpServletRequest req,ModelAndView model)
	{
		System.out.println(req.getParameter("tableNo"));
		int table=Integer.parseInt(req.getParameter("tableNo"));
		if(customerService.checkCorrectTable(table))
		{
			model.addObject("customer",customerService.getBill(table));
			model.addObject("flag", "bill");
			model.setViewName("customer/customer");
		}
		else
			model.setViewName("customer/index");
			return model;
	}
	//render Templates
	@RequestMapping("/addCustomerTemplate")
	private ModelAndView addTemplate(ModelAndView model) {
		model.addObject("availableTables", customerService.getavailableTables());
		model.setViewName("customer/NewCustomer");
		return model;

	}
	@RequestMapping("/addOrderTemplate")
	private String addOrderTemplate(@PathParam("tableNo")int tableNo,Model model) {
		if(customerService.checkCorrectTable(tableNo))
		{
			model.addAttribute("tableNo",tableNo);
	        model.addAttribute("orderItems",orderService.getAllOrderItems());
	        return "customer/addOrder";
		}
		return "redirect:/";
	}
	@RequestMapping(path="/addOrder",method=RequestMethod.GET)
	public String addOrder(HttpServletRequest req, HttpServletResponse resp) throws DataAccessException
    {
		
		String[] items=req.getParameterValues("items");
		String[] prices=req.getParameterValues("price");
		String[] counts=req.getParameterValues("count");
		List<OrderItemsOfCustomers> itemsOrdered= new ArrayList<OrderItemsOfCustomers>();
		for(int i=0;i<items.length;i++)
			itemsOrdered.add(new OrderItemsOfCustomers(items[i],Integer.parseInt(prices[i]), Integer.parseInt(counts[i])));
		customerService.addOrder(Integer.parseInt(req.getParameter("tableNo")),itemsOrdered);
		return "redirect:/";

    }
	@RequestMapping("/removeOrderedItems")
	public String removeOrderItems(HttpServletRequest req, HttpServletResponse resp) throws DataAccessException
    {
		System.out.println("hii");
		
		String[] items=req.getParameterValues("items");
		String[] counts=req.getParameterValues("count");
		customerService.removeOrderedItems(items,counts,Integer.parseInt(req.getParameter("tableNo")));
		return "redirect:/";

    }


}
