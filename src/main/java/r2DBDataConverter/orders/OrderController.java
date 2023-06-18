package r2DBDataConverter.orders;


import lombok.RequiredArgsConstructor;
import r2DBDataConverter.orders.repository.OrderRepository;

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
@RequestMapping("orders")
//@RequiredArgsConstructor
//@Import(value = { OrderRepository.class })
public class OrderController {

	//
    private final OrderRepository orders;
    @Autowired
    	public OrderController( OrderRepository orders) {//@Qualifier("OrderRepository")
	//	super();
		this.orders = orders;
	}

 
   

    @GetMapping("")
    public ResponseEntity<Flux<Order>> all() {
        return ok().body(this.orders.findAll());
    }






	

}