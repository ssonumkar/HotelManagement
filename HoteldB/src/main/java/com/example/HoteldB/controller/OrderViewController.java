package com.example.HoteldB.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.HoteldB.entity.Category;
import com.example.HoteldB.entity.OrderItem;
import com.example.HoteldB.entity.OrderItemsOfCustomers;
import com.example.HoteldB.service.OrderService;
@Controller
public class OrderViewController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping("/addOrderItems")
	private String addOrderItems(HttpServletRequest req)
	{
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		String[] items=req.getParameterValues("item");
		String[] prices=req.getParameterValues("price");
		String[] category=req.getParameterValues("category");
		for(int i=0;i<items.length;i++)
			orderItems.add(new OrderItem(items[i],Category.valueOf(category[i]),Integer.parseInt(prices[i])));
		orderService.addOrderItems(orderItems);
		return "redirect:/";
	}
	@RequestMapping("/addOrderItemsTemplate")
	private ModelAndView addOrderItemsTemplate(ModelAndView model)
	{
		model.addObject("categories", Category.values());
		model.setViewName("orderItem/addOrderItems");
		return model;
	}
	@RequestMapping("/updateOrderItemTemplate")
	private ModelAndView addOrderTemplate(ModelAndView model) {
	        model.addObject("orderItems",orderService.getAllOrderItems());
	        model.setViewName("orderItem/updateOrderItem");
	        return model;
		
	}
	@RequestMapping(path="/updateOrderItems",method = RequestMethod.GET )
	private String updateOrderItems(HttpServletRequest req,ModelAndView model) {
		String[] items=req.getParameterValues("item");
		String[] prices=req.getParameterValues("price");
		String[] category=req.getParameterValues("category");
		System.out.println(items);
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		for(int i=0;i<items.length;i++)
			orderItems.add(new OrderItem(items[i],Category.valueOf(category[i]),Integer.parseInt(prices[i])));
		orderService.updateOrderItems(orderItems);
		return "redirect:/";
	}
	
}
