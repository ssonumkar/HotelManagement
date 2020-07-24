package com.example.HoteldB.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HoteldB.entity.Category;
import com.example.HoteldB.entity.OrderItem;
import com.example.HoteldB.model.OrderCrudOperations;
@Service
public class OrderService {

	@Autowired
	OrderCrudOperations crudOperation;
	public int getPrice(Category category, String item) {
		return crudOperation.getPrice(category,item);
	}
//	public Map<String, List<String>> getAllOrderItems() {
//		crudOperation.getAll
//		return null;
//	}
	public Map<Category, List<String>> getAllOrderItems() {
		Map<Category, List<String>> orderItems=new HashMap<Category, List<String>>();
		for (Category category : Category.values()) 
			orderItems.put(category, crudOperation.getOrerItemsByCategory(category));
		return orderItems;
	}
	public void addOrderItem(OrderItem orderItem) {
		crudOperation.save(orderItem);
		
	}
	public void addOrderItems(List<OrderItem> orderItems) {
		crudOperation.saveAll(orderItems);
	}
	public void updateOrderItems(List<OrderItem> orderItems) {
		for (OrderItem orderItem : orderItems) 
		{
			
			OrderItem item=new OrderItem();
			item=crudOperation.getItemByItemName(orderItem.getItem());
			item.setCategory(orderItem.getCategory());
			item.setPrice(orderItem.getPrice());
			crudOperation.save(item);
		}
		
	}
	public void deleteOrderItems(String[] items) {
		for (String item : items) {
			crudOperation.delete(crudOperation.getItemByItemName(item));
		}
		
	}
	
}
