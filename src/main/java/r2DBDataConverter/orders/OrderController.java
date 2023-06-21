package r2DBDataConverter.orders;


import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

@RestController
@RequestMapping("orders")
//@RequiredArgsConstructor
//@Import(value = { OrderRepository.class })
public class OrderController {

	//    @Autowired
    private final OrderRepository orderRepository;

    	public OrderController( OrderRepository orderRepository) {//@Qualifier("OrderRepository")
		super();
		this.orderRepository = orderRepository;
	}

 
    @GetMapping("")
    public ResponseEntity<Flux<Order>> all() {
        return ok().body(this.orderRepository.findAll());
    }


  

	

}