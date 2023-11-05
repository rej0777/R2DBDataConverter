package r2DBDataConverter.dataSoursesConfig.sqlTable1B;


import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.core.DefaultReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.dialect.SqlServerDialect;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;

//import javax.annotation.PostConstruct;


@Configuration
@EnableR2dbcRepositories(entityOperationsRef = "customersEntityTemplate" )
public class Table1BConfig {
	
	
    @Bean
    @Qualifier(value = "customersConnectionFactory")
    public ConnectionFactory customersConnectionFactory() {
        return ConnectionFactories.get("r2dbc:sqlserver://sa:85221@192.168.0.24/db1");
    }

    @Bean
    public R2dbcEntityOperations customersEntityTemplate(@Qualifier("customersConnectionFactory") ConnectionFactory connectionFactory) {

        DefaultReactiveDataAccessStrategy strategy = new DefaultReactiveDataAccessStrategy(SqlServerDialect.INSTANCE);//MySqlDialect.INSTANCE
        DatabaseClient databaseClient = DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .bindMarkers(SqlServerDialect.INSTANCE.getBindMarkersFactory())
                .build();

        return new R2dbcEntityTemplate(databaseClient, strategy);
    }

	/*
	  
   // @PostConstruct
    public void initialize() {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.addScripts(
                new ClassPathResource("scripts/customers/schema.sql"),
                new ClassPathResource("scripts/customers/data.sql")
        );
        databasePopulator.populate(customersConnectionFactory()).subscribe();
    } */ 

    
	/*
	
	SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Table1B](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DATE_TIME] [datetime2](6) NULL,
	[FIRST_NAME] [varchar](255) NOT NULL,
    [PRICE] [float] NULL,
    [VALUE2] [bigint] NOT NULL,
    [SEASON] [char](1) NULL,
    
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

	
	*/
    
}