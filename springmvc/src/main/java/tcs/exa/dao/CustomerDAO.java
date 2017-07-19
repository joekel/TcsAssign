package tcs.exa.dao;

import java.util.List;

import tcs.exa.domain.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> listAll() ;

	public void saveOrUpdate(Customer thecustomer);

	public Customer getById(int theID);

	public void delete(int theID); 

}
