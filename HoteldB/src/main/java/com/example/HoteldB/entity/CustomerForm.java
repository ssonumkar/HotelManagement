package com.example.HoteldB.entity;

import java.io.Serializable;
import java.util.List;

public class CustomerForm implements Serializable{

	@Override
	public String toString() {
		return "CustomerForm [table=" + table + ", name=" + name + ", orderedItems=" + orderedItems + "]";
	}
	int table;
	String name;
	List<OrderItem> orderedItems=null;
	public int getTable() {
		return table;
	}
	public void setTable(int table) {
		this.table = table;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
