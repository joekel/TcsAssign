package tcs.exa;

import static org.apache.camel.model.rest.RestParamType.path;
import static org.apache.camel.model.rest.RestParamType.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xmljson.XmlJsonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import tcs.exa.domain.Customer;

/**
 * 
 * @author Jaber Kaal
 *
 */
@Component
public class Camel extends RouteBuilder {

	@Override
	public void configure() throws Exception {
	
		
		// @formatter:off
		restConfiguration().component("servlet")
				.bindingMode(RestBindingMode.auto)
				.dataFormatProperty("prettyPrint", "true")
				.apiContextPath("/api-doc")
				.apiProperty("api.title", "User API")
				.apiProperty("api.version", "1.0.0")
				.apiProperty("cors", "true");

		rest("/api").description("User REST service")
				.consumes("application/json").produces("application/json")

				.get().description("Find all users")
				.outTypeList(Customer.class).responseMessage().code(200)
				.message("All users successfully returned")
				.endResponseMessage()
				.to("bean:customerServiceImpl?method=listAll")

				.get("/{id}").description("Find user by ID")
				.outType(Customer.class).param().name("id").type(path)
				.description("The ID of the user").dataType("integer")
				.endParam().responseMessage().code(200)
				.message("User successfully returned").endResponseMessage()
				.to("bean:customerServiceImpl?method=getById(${header.id})")

				.put("/").description("Update a user").type(Customer.class)
				.param().name("id").type(path)
				.description("The ID of the user to update")
				.dataType("integer").endParam().param().name("body").type(body)
				.description("The user to update").endParam().responseMessage()
				.code(204).message("User successfully updated")
				.endResponseMessage()
				.to("bean:customerServiceImpl?method=saveOrUpdate");
	

	
	}

}
