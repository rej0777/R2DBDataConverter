package r2DBDataConverter.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

//@Qualifier("CustomerRepository")
public interface CustomerRepository extends R2dbcRepository<Customer, Long> {  //
	
}