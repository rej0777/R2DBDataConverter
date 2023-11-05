package r2DBDataConverter;

import java.util.Arrays;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.repository.RepositoryDefinition;



//@ComponentScans("r2DBDataConverter.orders.repository" )
//@ComponentScan(basePackages = {"r2DBDataConverter.orders.repository", , "r2DBDataConverter.customer.repository",})
//@EnableR2dbcRepositories
@SpringBootApplication(scanBasePackages={ "r2DBDataConverter.dataSoursesConfig", "userApi"} )//, "r2DBDataConverter.orders"
public class R2DbDataConverterApplication {

	public static void main(String[] args) {
		//SpringApplication.run(R2DbDataConverterApplication.class, args);
		
		ApplicationContext ctx = SpringApplication.run(R2DbDataConverterApplication.class, args);
        System.out.println("Inspecting the beans");
           
        String[] beans = ctx.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String name : beans) {
            System.out.println("Bean Name" +name);
        }
		/*    
		   
		int exitCode = SpringApplication.exit(ctx, new ExitCodeGenerator() {
			@Override
			public int getExitCode() {
				return 0;
			}
		});

		System.exit(exitCode);
*/
	} 

}
//https://docs.spring.io/spring-data/r2dbc/docs/1.1.3.RELEASE/reference/html/#r2dbc.multiple-databases