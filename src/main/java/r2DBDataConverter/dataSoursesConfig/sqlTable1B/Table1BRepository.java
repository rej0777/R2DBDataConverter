package r2DBDataConverter.dataSoursesConfig.sqlTable1B;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

//@Qualifier("CustomerRepository")
public interface Table1BRepository extends R2dbcRepository<Table1B, Long> {  //
	
}