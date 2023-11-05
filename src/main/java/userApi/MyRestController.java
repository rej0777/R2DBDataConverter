package userApi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import r2DBDataConverter.dataSoursesConfig.sqlTable1A.Table1A;
import r2DBDataConverter.dataSoursesConfig.sqlTable1A.Table1ARepository;
import r2DBDataConverter.dataSoursesConfig.sqlTable1B.Table1B;
import r2DBDataConverter.dataSoursesConfig.sqlTable1B.Table1BRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("appv1")
public class MyRestController {

	
    private final Table1ARepository table1ARepo;
    private final Table1BRepository table1BRepo;
    
	public MyRestController(Table1ARepository table1aRepo, Table1BRepository table1bRepo) {
		super();
		table1ARepo = table1aRepo;
		table1BRepo = table1bRepo;
	}
	
	 @GetMapping("convert")
    private void sqlConvert() {
		
		 test1().map( t -> {
			 Table1B tab1B= new Table1B();
			 
			 tab1B.setDateTime(t.getDateTime());
			 tab1B.setFirstName("FirstName"+t.getValue2());
			 tab1B.setValue2(t.getValue2().intValue());
			 tab1B.setPrice(t.getValue1());
			 tab1B.setBl((t.getValue1()%2)==0 ? true: false);
			 
			 return tab1B;
		 })
		 .buffer(1000)
		 .log()
		 .flatMap( t ->table1BRepo.saveAll(t) )
		 .subscribe();

	}
	
	

	Flux<Table1A> test1() {
		return table1ARepo.findAll();
	}

}
         