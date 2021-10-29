package com.example.lucassilvapessoa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lucassilvapessoa.model.Customer;
import com.example.lucassilvapessoa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(customerService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Customer customer){
		return ResponseEntity.ok(customerService.save(customer));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Customer customer){
	  return ResponseEntity.ok(customerService.update(id, customer));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
	    customerService.delete(id);
	    return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	public Page<Customer> findAll(@RequestParam(required = false, name = "firstname") Optional<String> fisrtName, 
		@RequestParam(name = "page", required = false) Optional<Integer> page){
		return customerService.findAllByFilter(fisrtName);
	}
}
