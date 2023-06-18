package r2DBDataConverter.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;


@RestController
@RequestMapping("customers")
//@RequiredArgsConstructor
public class CustomerController {

	@Autowired
    private final CustomerRepository customers;

	public CustomerController(@Qualifier("OrderRepository") CustomerRepository customers) {
		super();
		this.customers = customers;
	}
	
    @GetMapping("")
    public ResponseEntity<Flux<Customer>> all() {
        return ok().body(this.customers.findAll());
    }



	

}