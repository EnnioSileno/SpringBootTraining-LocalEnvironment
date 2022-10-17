package ch.ennio.sileno.sqltest.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
public class StudentService {

    public List<Student> getStudents() {
        Student ennio = new Student(1L,
                "Ennio Sileno",
                "esileno@gmail.com",
                LocalDate.of(1997, Month.AUGUST, 10),
                25);
        Student robin = new Student(2L,
                "Robin Sileno",
                "robin@gmail.com",
                LocalDate.of(1999, Month.AUGUST, 27),
                23);
        return List.of(ennio, robin);
    }
}
