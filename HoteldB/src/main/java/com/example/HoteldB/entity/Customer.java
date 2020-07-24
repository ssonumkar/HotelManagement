package com.example.HoteldB.entity;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Customer 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
    int id;
    @Column(nullable = false)
    int tableNo;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    int flag;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    Bill bill;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Customer(int tableNo, String name,Bill bill) {
		super();
		this.tableNo = tableNo;
		this.name = name;
		this.flag = 1;
		this.bill = bill;
		this.bill.setCustomer(this);
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
    
    
    

}
