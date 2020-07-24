package com.example.HoteldB.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	int id;
	@Column(unique = true, nullable = false)
	String item;
	@Column(nullable = false)
	Category category;
	@Column(nullable = false)
	int price;
	@Transient
	List<OrderItemsOfCustomers> items;
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderItem [item=" + item + ", category=" + category + ", price=" + price + "]";
	}
	public List<OrderItemsOfCustomers> getItems() {
		return items;
	}
	public void setItems(List<OrderItemsOfCustomers> items) {
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Category getCategory() {
		return category;
	}
	public OrderItem(String item, Category category, int price) {
		super();
		this.item = item;
		this.category = category;
		this.price = price;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
