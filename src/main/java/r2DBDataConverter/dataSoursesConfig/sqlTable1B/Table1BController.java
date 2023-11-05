package r2DBDataConverter.dataSoursesConfig.sqlTable1B;

import lombok.RequiredArgsConstructor;

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

import static org.springframework.http.ResponseEntity.ok;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;


@RestController
@RequestMapping("table1B")
public class Table1BController {

//	@Autowired
    private final Table1BRepository table1BRepo;

	public Table1BController(Table1BRepository Table1BRepo) {//@Qualifier("OrderRepository") 
		super();
		this.table1BRepo = Table1BRepo;
	}
	
    @GetMapping("")
    public ResponseEntity<Flux<Table1B>> all() {
        return ok().body(this.table1BRepo.findAll());
    }

    
    @PostMapping("save1")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Mono<Table1B> create(@RequestBody Table1B tb1) {
		return saveObject(tb1);
	}

	
	public Mono<Table1B> saveObject(Table1B tb1) {
		
		System.out.println(tb1);
		
	//	Table1B tb2 = new Table1B(null,LocalDateTime.now(), "produkt5" ,1246D, 345,true);
		
		return table1BRepo.save(tb1);
	}

	

}