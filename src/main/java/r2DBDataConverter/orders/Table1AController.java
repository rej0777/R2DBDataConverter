package r2DBDataConverter.orders;


import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.Disposable;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.ParallelFlux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;


import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.convert.ConversionService;

@RestController
@RequestMapping("table1")
//@RequiredArgsConstructor
//@Import(value = { OrderRepository.class })
public class Table1AController {

	//    @Autowired
    private final Table1ARepository repository;
  


    	public Table1AController( Table1ARepository tr) {//@Qualifier("OrderRepository")
		super();
		this.repository = tr;
	}
 
    @GetMapping("")
    public ResponseEntity<Flux<Table1A>> all() {
        return ok().body(this.repository.findAll());
    }
   
    
	/* BODy RAW
	 {    "str1": "abc",   "value1":1000,   "value2":2000 }*/
	
    @PostMapping("save1")
    @ResponseStatus(value = HttpStatus.CREATED)//HttpStatus.CREATED)
    public Mono<Table1A> create(@RequestBody Table1A tb1){ //  
        return createUser(tb1); 
    }

    public Mono<Table1A> createUser(Table1A user){
        return repository.save(user);
    }
    

   
    @GetMapping("generate")
    @ResponseStatus(value = HttpStatus.CREATED)
	public   HttpStatus generateFLUX2() {
  	   	
    	generateFLUX().map(t -> (Table1A)t )
    	.buffer(1000)
    	.log()
    	.flatMap(t ->  repository.saveAll(  t ) ).subscribe();
    	
    	System.out.println("zapisane" );
    	return HttpStatus.OK;
    }
    
    
   
      
    
    AtomicInteger i = new AtomicInteger(1); 
	public  Flux<Object> generateFLUX() {	

		
	return	  Flux.generate(Table1A::new, (state, sink) -> {
		
			state.setDateTime(LocalDateTime.now());
			state.setStr1("Str "+i+2);
			state.setValue1(Double.valueOf(5+i.doubleValue()));
			state.setValue2(Long.valueOf(5+i.longValue()*2));
			sink.next(state);
			i.incrementAndGet();
	//		if (i == 1000)
	//			sink.complete();
			return state;			  

		  })
			.take(4000)	
			.subscribeOn(Schedulers.boundedElastic());
	}

}