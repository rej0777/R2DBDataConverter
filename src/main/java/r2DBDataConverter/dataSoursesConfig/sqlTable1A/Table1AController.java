package r2DBDataConverter.dataSoursesConfig.sqlTable1A;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import static org.springframework.http.ResponseEntity.ok;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDateTime;

@RestController
@RequestMapping("table1A")
public class Table1AController {

	//    @Autowired
    private final Table1ARepository repository;
  


    	public Table1AController( Table1ARepository tr) {
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
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Table1A> create(@RequestBody Table1A tb1){
        return createUser(tb1); 
    }

    public Mono<Table1A> createUser(Table1A user){
        return repository.save(user);
    }
    

   
    @GetMapping("generate")
    @ResponseStatus(value = HttpStatus.CREATED)
	public   HttpStatus generateFLUX2() {
    	final long start = System.nanoTime();
    	    	
    	generateFLUX().map(t -> (Table1A)t )
    	.buffer(1000)
    	.log()
    	.flatMap(t ->  repository.saveAll(  t ) )
    	.doFinally(endType -> System.out.println("Time taken : " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start) + " milliseconds."))
    	.subscribe();
    	
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
			.take(20000)	
			.subscribeOn(Schedulers.boundedElastic());
	}
	
}