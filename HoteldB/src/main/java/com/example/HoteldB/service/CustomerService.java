package com.example.HoteldB.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HoteldB.entity.Bill;
import com.example.HoteldB.entity.Customer;
import com.example.HoteldB.entity.CustomerForm;
import com.example.HoteldB.entity.OrderItem;
import com.example.HoteldB.entity.OrderItemsOfCustomers;
import com.example.HoteldB.exceptions.FieldWithNullValueException;
import com.example.HoteldB.model.CustomerCrudOperations;
import com.example.HoteldB.model.OrderItemsOfCustomerCrudOperations;
@Service
public class CustomerService {
	
	@Autowired
	CustomerCrudOperations crudoperations;
	@Autowired
	OrderItemsOfCustomerCrudOperations itemCrudOp;
	static List<Integer> availableTables ;
	public CustomerService() {
		availableTables=new ArrayList<Integer>();
		for(int i=1;i<=10;i++)
			availableTables.add(i);
	}
	
	public boolean addCustomer(CustomerForm form) throws FieldWithNullValueException
	{
		try {
			if(form.getTable()==0 || form.getName()==null)
				throw new FieldWithNullValueException();
		} catch (FieldWithNullValueException e) {
			System.out.println(e.getMessage());
			return false;
		}
		crudoperations.save(new Customer(form.getTable(),form.getName(),new Bill()));
		System.out.println(form.getTable()+":"+availableTables);
		availableTables.remove((Integer)form.getTable());
		return true;
	}
	public List<Customer> getCurrentCustomers()
	{
		return crudoperations.findByFlag(1);
	}
	public Iterable<Customer> getAllOldCustomers()
	{
		return crudoperations.getAllOldCustomers();
	}
	public Customer getCustomerById(int id)
	{
		return crudoperations.findById(id).get();
	}
	public Customer getCustomerByTable(int table)
	{
		return crudoperations.findByTableNo(table).get();
	}
	
	public Customer getBill(int tableNo)
	{
		Customer customer = crudoperations.findByTableNo(tableNo).get();
		Customer cust=customer;
		availableTables.add(cust.getTableNo());
		customer.setFlag(0);
		crudoperations.save(customer);
		return cust;
	}
	public List<Integer> getavailableTables()
	{
		return availableTables;
		
	}

	public boolean checkCorrectTable(int tableNo) {
		
		if(availableTables.contains(tableNo))
			return false;
		return true;
	}
	public void initializeTableCount()
	{
		availableTables.removeAll(crudoperations.getAllTables());
	}

	public void addOrder(int table, List<OrderItemsOfCustomers> itemsOrdered) {
		Customer cust=getCustomerByTable(table);
		ArrayList<String> prevItems=itemCrudOp.getItemNames(cust.getBill());
		List<OrderItemsOfCustomers> removeItems=new ArrayList<OrderItemsOfCustomers>();
		int bill=cust.getBill().getTotalBill();
		for (OrderItemsOfCustomers item : itemsOrdered)
		{					
				bill+=item.getPrice();
				item.setBill(cust.getBill());//map cust's bill object to items bill object
				//System.out.println(prevItems+" : "+item.getItem());
				if(prevItems.contains(item.getItem()))
				{
					System.out.println("hi");
					cust.getBill().getOrderItems().get(prevItems.indexOf(item.getItem())).
						setQuantity(item.getQuantity());//merge is done in set() of OrderItemsOfCustomer
					
					removeItems.add(item);
				}
		}
		itemsOrdered.removeAll(removeItems);
		System.out.println(cust.getBill().getOrderItems());
		cust.getBill().setTotalBill(bill);
		cust.getBill().getOrderItems().addAll(itemsOrdered);
		crudoperations.save(cust);
	}

	public void removeOrderedItems(String[] items, String[] counts, int table) {
		Customer cust=getCustomerByTable(table);
		for(int i=0;i<items.length;i++)
		{
			OrderItemsOfCustomers orderItem=itemCrudOp.getItemByName(items[i],cust.getBill());
			System.out.println(orderItem+":"+Integer.parseInt(counts[i]));
			orderItem.setQuantity(orderItem.getQuantity()-Integer.parseInt(counts[i]));
			if(orderItem.getQuantity()<=0)
				itemCrudOp.delete(orderItem);
		}
		crudoperations.save(cust);
	}
}
