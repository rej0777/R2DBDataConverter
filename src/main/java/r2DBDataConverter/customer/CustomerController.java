package r2DBDataConverter.customer;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;


@RestController
@RequestMapping("customers")
//@RequiredArgsConstructor
public class CustomerController {

//	@Autowired
    private final CustomerRepository customerRepository;

	public CustomerController(CustomerRepository customerRepository) {//@Qualifier("OrderRepository") 
		super();
		this.customerRepository = customerRepository;
	}
	
    @GetMapping("")
    public ResponseEntity<Flux<Customer>> all() {
        return ok().body(this.customerRepository.findAll());
    }

    @GetMapping("test")
    public Mono<Customer> print() {
    	
    return	Mono.fromSupplier(() -> new Customer(99L ,"aaa", "fff"));
  //  	Customer ct= new Customer();
  //  	ct.setFirstName("aaa");
   // 	ct.setLastName("qq");
   //     return ok().body(ct);
    }


	

}