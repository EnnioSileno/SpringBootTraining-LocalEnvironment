package ch.ennio.sileno.sqltest.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student with studentId " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String newName, String newEmail) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student with studentId " + studentId + " does not exist"));

        if(newName != null &&
                !newName.isEmpty() &&
                !newName.equals(student.getName())) {
            student.setName(newName);
        }

        if(newEmail != null &&
                !newEmail.isEmpty() &&
                !newEmail.equals(student.getEmail())) {
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(newEmail);
            if(optionalStudent.isPresent()) {
                throw new IllegalStateException("email already taken");
            }
            student.setEmail(newEmail);
        }
    }
}
