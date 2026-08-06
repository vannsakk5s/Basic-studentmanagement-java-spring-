package setec.com.lebjavaspringb.features.teacher;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import setec.com.lebjavaspringb.exceptions.MyResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacherAll() {
        return teacherRepository.findAll();
    }

    public Teacher createTeacher(TeacherRequest request) {

        Teacher teacher = Teacher.builder()
                .lastName(request.lastName())
                .firstName(request.firstName())
                .gender(request.gender())
                .dob(request.dob())
                .address(request.address())
                .salary(request.salary())
                .tellPhone(request.tellPhone())
                .subjectName(request.subjectName())
                .build();

        return teacherRepository.save(teacher);
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() ->
                        new MyResourceNotFoundException(
                                "Teacher not found with id: " + id
                        )
                );
    }

    public Teacher updateById(Long id, TeacherRequest request) {

        Teacher teacher = findById(id);

        teacher.setLastName(request.lastName());
        teacher.setFirstName(request.firstName());
        teacher.setGender(request.gender());
        teacher.setDob(request.dob());
        teacher.setAddress(request.address());
        teacher.setSalary(request.salary());
        teacher.setTellPhone(request.tellPhone());
        teacher.setSubjectName(request.subjectName());

        return teacherRepository.save(teacher);
    }

    public void deleteById(Long id) {
        Teacher teacher = findById(id);
        teacherRepository.delete(teacher);
    }

    public Page<Teacher> findTeacherByName(
            String name,
            Pageable pageable
    ) {
        return teacherRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        name,
                        name,
                        pageable
                );
    }
}