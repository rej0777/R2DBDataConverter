package r2DBDataConverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.RepositoryDefinition;


@ComponentScan("r2DBDataConverter.orders.repository")
@EnableR2dbcRepositories
@SpringBootApplication
public class R2DbDataConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2DbDataConverterApplication.class, args);
	}

}
