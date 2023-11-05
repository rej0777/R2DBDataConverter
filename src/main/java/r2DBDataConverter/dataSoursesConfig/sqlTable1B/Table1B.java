package r2DBDataConverter.dataSoursesConfig.sqlTable1B;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Table(value = "Table1B")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Table1B implements Serializable {

	private static final long serialVersionUID = 6320887322001086806L;

	@Id 
	@Column(value = "ID")
	private Long id;	
	
	@Column(value = "DATE_TIME")//
	private LocalDateTime dateTime;	
	
	 @Column(value = "FIRST_NAME")
    private String firstName;

	@Column(value = "PRICE")	
	protected Double price;	
	
	@Column(value = "VALUE2")	
	protected Integer value2;	

	@Column(value = "BOOLTRUE" )
	protected boolean bl;
    
}