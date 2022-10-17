package ch.ennio.sileno.sqltest;

import ch.ennio.sileno.sqltest.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SqltestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqltestApplication.class, args);
	}

}
