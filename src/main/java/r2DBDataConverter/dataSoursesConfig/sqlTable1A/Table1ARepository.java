package r2DBDataConverter.dataSoursesConfig.sqlTable1A;

import java.util.Iterator;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.core.ReactiveInsertOperation.ReactiveInsert;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

@EnableR2dbcRepositories
public interface Table1ARepository extends R2dbcRepository<Table1A,Long> {



	

	
	
}