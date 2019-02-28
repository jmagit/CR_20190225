package curso.dto;

import org.springframework.data.rest.core.config.Projection;

import curso.model.Customer;

@Projection(name = "clientes-list", types = { Customer.class }) 
public interface CustomerListProjection {
	String getFirstName();
	String getLastName();
}
