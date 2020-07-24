package com.example.HoteldB.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Bill implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@JsonFormat
	Date date;
	@OneToMany(mappedBy = "bill" ,cascade = CascadeType.ALL)
	List<OrderItemsOfCustomers> orderItems=new ArrayList<OrderItemsOfCustomers>();
	int totalBill=0;
	@OneToOne(mappedBy = "bill")
	Customer customer;
	@Override
	public String toString() {
		return "Bill [Table=" + customer.tableNo + ", customer=" + customer.name + ",totalBill=" + totalBill + "]";
	}
	public Bill() {
		super();
		this.date = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public List<OrderItemsOfCustomers> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemsOfCustomers> orderItems) {
		this.orderItems.addAll(orderItems);
	}
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
