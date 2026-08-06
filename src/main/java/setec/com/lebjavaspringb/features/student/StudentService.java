package setec.com.lebjavaspringb.features.student;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import setec.com.lebjavaspringb.exceptions.MyResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    public Student createStudent(StudentRequest request) {

        Student student = Student.builder()
                .lastName(request.lastName())
                .firstName(request.firstName())
                .gender(request.gender())
                .dob(request.dob())
                .address(request.address())
                .email(request.email())
                .subjectName(request.subjectName())
                .build();

        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new MyResourceNotFoundException(
                                "Student not found with id: " + id
                        )
                );
    }

    public Student updateById(Long id, StudentRequest request) {

        Student student = findById(id);

        student.setLastName(request.lastName());
        student.setFirstName(request.firstName());
        student.setGender(request.gender());
        student.setDob(request.dob());
        student.setAddress(request.address());
        student.setEmail(request.email());
        student.setSubjectName(request.subjectName());

        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        studentRepository.delete(student);
    }

    public Page<Student> findStudentByName(
            String name,
            Pageable pageable
    ) {
        return studentRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        name,
                        name,
                        pageable
                );
    }
}