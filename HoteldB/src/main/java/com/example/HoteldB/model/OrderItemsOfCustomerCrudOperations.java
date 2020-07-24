package com.example.HoteldB.model;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.HoteldB.entity.Bill;
import com.example.HoteldB.entity.OrderItemsOfCustomers;

public interface OrderItemsOfCustomerCrudOperations extends CrudRepository<OrderItemsOfCustomers, Integer>{

	@Query("select c.item from OrderItemsOfCustomers c where c.bill=:bill")
	ArrayList<String> getItemNames(Bill bill);

	@Query("select c from OrderItemsOfCustomers c where c.bill=:bill and c.item=:item")
	OrderItemsOfCustomers getItemByName(String item, Bill bill);

}
