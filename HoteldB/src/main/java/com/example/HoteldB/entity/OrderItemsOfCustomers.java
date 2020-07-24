package com.example.HoteldB.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class OrderItemsOfCustomers{

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill == null) ? 0 : bill.hashCode());
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + price;
		result = prime * result + quantity;
		return result;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String item;
	int price;
	int quantity;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name="billID")
	Bill bill;
	public OrderItemsOfCustomers() {
		// TODO Auto-generated constructor stub
	}
	public OrderItemsOfCustomers(String item, int price, int quantity) {
		super();
		this.item = item;
		this.price = price;
		this.quantity = quantity;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "OrderItemForm [item=" + item + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}
