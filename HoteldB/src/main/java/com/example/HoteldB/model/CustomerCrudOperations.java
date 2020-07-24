package com.example.HoteldB.model;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.HoteldB.entity.Customer;

public interface CustomerCrudOperations extends CrudRepository<Customer, Integer>{

	@Query("select c from Customer c where c.flag=:flag")
	public List<Customer> findByFlag(@Param("flag") int flag);
	
	@Query("select c from Customer c where tableNo=:tableNo and flag=1")
	public Optional<Customer> findByTableNo(@Param("tableNo")int tableNo);
	@Query("select c.tableNo from Customer c where c.flag=1")
	public Collection<?> getAllTables();
	@Query("select c from Customer c where flag=0")	
	public Iterable<Customer> getAllOldCustomers();
}
