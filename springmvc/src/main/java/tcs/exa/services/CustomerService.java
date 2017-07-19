package tcs.exa.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import tcs.exa.domain.Customer;

@Produces({"application/xml","application/json"})
public interface CustomerService{
	
	
	@GET
	@Path("/customer/")
    public List<Customer> listAll();
	

	@GET
	@Path("/customer/{id}/")
    public Customer getById( @PathParam("id") int id);
   

	@PUT
	@Path("/customer/")
    public void saveOrUpdate(Customer customer);
   
	@DELETE
	@Path("/customer/{id}/")
    public Response delete(@PathParam("id") int id);
}
