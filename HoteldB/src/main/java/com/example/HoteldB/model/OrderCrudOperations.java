package com.example.HoteldB.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.HoteldB.entity.Category;
import com.example.HoteldB.entity.OrderItem;

public interface OrderCrudOperations extends CrudRepository<OrderItem, Integer>{

	@Query("select o from OrderItem o where o.category =:category and o.item=:item")
	int getPrice(Category category, String item);
	@Query("select o.item,o.price from OrderItem o where o.category=:c")
	List<String> getOrerItemsByCategory(Category c);
	@Query("select o from OrderItem o where o.item=:item")
	OrderItem getItemByItemName(String item);
	
}
