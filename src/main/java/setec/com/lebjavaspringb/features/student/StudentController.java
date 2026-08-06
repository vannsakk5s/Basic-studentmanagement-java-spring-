package setec.com.lebjavaspringb.features.student;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Tag(
        name = "Student"
//        description = "Student management APIs"
)
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> getStudentAll() {
        return studentService.getStudentAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(
            @Valid @RequestBody StudentRequest request
    ) {
        return studentService.createStudent(request);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @PutMapping("/{id}")
    public Student updateById(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request
    ) {
        return studentService.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/search")
    public Page<Student> findStudentByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return studentService.findStudentByName(
                name,
                PageRequest.of(page, size)
        );
    }
}