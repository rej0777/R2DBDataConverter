package r2DBDataConverter.dataSoursesConfig.sqlTable1A;

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

//see: https://r2dbc.io/spec/0.8.2.RELEASE/spec/html/#datatypes.mapping.numeric
//and https://www.postgresql.org/docs/10/datatype-numeric.html

@Entity
@Table(value = "Table1A")
@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Table1A implements Serializable {



	private static final long serialVersionUID = 1082923337032951966L;
	
	
	@Id	
//	@SequenceGenerator(name = "SequenceIdGenerator", sequenceName = "table1a_id_seq", allocationSize = 10 )
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SequenceIdGenerator")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(value = "ID")	
	 private Long id;

	@Column(value = "DTSTAMP")
	private LocalDateTime dateTime;	
	
	@Column(value =  "STR1")
	private String str1;	
	
	@Column(value = "VALUE1")	
	protected Double value1;	
	
	@Column(value =  "VALUE2")
	protected Long value2;	
	
}