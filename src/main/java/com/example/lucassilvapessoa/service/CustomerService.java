package com.example.lucassilvapessoa.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.lucassilvapessoa.exceptions.CustumerNotFoundException;
import com.example.lucassilvapessoa.exceptions.FirstNameMustBeUniqueException;
import com.example.lucassilvapessoa.model.Customer;
import com.example.lucassilvapessoa.repository.CustomerRepositoy;
import com.example.lucassilvapessoa.specification.CostumerSpecification;
import com.example.lucassilvapessoa.ultil.PageBuider;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepositoy customerRepositoy;
	
	public Customer save(Customer customer) {
	  Optional<Customer> optionalCustomer = customerRepositoy.findByFirstName(customer.getFirstName());
	  if(optionalCustomer.isPresent()) throw new FirstNameMustBeUniqueException();
	  return customerRepositoy.save(customer);
	}
	
	public Customer findById(Long id) {
	  Optional<Customer> optionalCustomer = customerRepositoy.findById(id);
	  if(optionalCustomer.isPresent())
	  return optionalCustomer.get();
	  throw new CustumerNotFoundException(id);
	}

	public Customer update(Long id, Customer customer) {
	  Customer oldCustomer = findById(id);
	  customer.setId(oldCustomer.getId());
	  return customerRepositoy.save(customer);
	}

	public void delete(Long id) {
	  findById(id);
	  customerRepositoy.deleteById(id);
	}
	
	public java.util.List<Customer> findAll(){
		return customerRepositoy.findAll();
	}
	
	public Page<Customer> findAllByFilter(Optional<String> firstName){
		return customerRepositoy.findAll(CostumerSpecification.setSpecification(firstName),
		new PageBuider().setPage(0).buid());
	}
}
