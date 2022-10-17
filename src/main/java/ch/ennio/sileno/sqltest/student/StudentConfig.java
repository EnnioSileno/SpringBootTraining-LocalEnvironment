package ch.ennio.sileno.sqltest.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static javax.xml.datatype.DatatypeConstants.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ennio = new Student(1L,
                    "Ennio Sileno",
                    "esileno@gmail.com",
                    LocalDate.of(1997, AUGUST, 10)
            );
            Student robin = new Student(2L,
                    "Robin Sileno",
                    "robin@gmail.com",
                    LocalDate.of(1999, AUGUST, 27)
            );
            repository.saveAll(
                    List.of(ennio, robin)
            );
        };
    }
}
