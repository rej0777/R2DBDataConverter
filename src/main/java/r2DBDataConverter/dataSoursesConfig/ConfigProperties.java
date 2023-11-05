package r2DBDataConverter.dataSoursesConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;

@Component
@ConfigurationProperties(prefix = "backup-config")
@Validated
public class ConfigProperties {

	
	//@NotBlank(message = "!!! tryb pracy nie moze byc pudty")
	private String trybPracy;

	//@Min(value = 360, message = "!!!minimalna wartosc 360")
	private int dniwstecz;
	
}
