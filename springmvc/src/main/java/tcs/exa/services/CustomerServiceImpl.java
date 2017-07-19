package tcs.exa.services;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import tcs.exa.dao.CustomerDAO;
import tcs.exa.domain.Customer;
import exception.SomeBusinessException;

@Service(value = "customerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

	public CustomerDAO customerDAO;
	

	@Autowired
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public List<Customer> listAll() {
		return customerDAO.listAll();
	}

	@Override
	public Customer getById(int id) {
		Customer cus = customerDAO.getById(id);
		return cus;
		

	}

	@Override
	public void saveOrUpdate(Customer customer) {
		customerDAO.saveOrUpdate(customer);
	}

	@Override
	public Response delete(int id) {

		Response response;

		if (customerDAO.getById(id) != null) {
			response = Response.ok().build();
			customerDAO.delete(id);
		} else {
			throw new SomeBusinessException("Business Exception");
		}

		return response;
	}

}
