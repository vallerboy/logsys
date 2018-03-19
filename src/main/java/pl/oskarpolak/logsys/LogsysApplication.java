package pl.oskarpolak.logsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan (
		basePackageClasses = {LogsysApplication.class, Jsr310JpaConverters.class}
)
public class LogsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogsysApplication.class, args);
	}
}
