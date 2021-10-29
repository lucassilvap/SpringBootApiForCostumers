package com.example.lucassilvapessoa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.lucassilvapessoa.model.Customer;

@Repository
public interface CustomerRepositoy extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer>{
	
	Optional<Customer> findByFirstName(String firstName);
	
	List<Customer> findAll();
	
}
