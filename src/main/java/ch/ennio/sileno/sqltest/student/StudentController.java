package ch.ennio.sileno.sqltest.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @GetMapping
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
