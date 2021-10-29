package com.example.lucassilvapessoa.specification;

import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;

import com.example.lucassilvapessoa.model.Customer;

public class CostumerSpecification {
  
	private static Specification<Customer> eqIsFirstName(String firstName){
		return (root, query, criteriaBuilder) 
			      -> criteriaBuilder.equal(root.get("firstName"), firstName);
	}
	
	public static Specification<Customer> setSpecification(Optional<String> firstName){
		Specification<Customer> spec = null;
	
		if(firstName.isPresent())
		spec = eqIsFirstName(firstName.get());
		
		return spec;
	}
}
