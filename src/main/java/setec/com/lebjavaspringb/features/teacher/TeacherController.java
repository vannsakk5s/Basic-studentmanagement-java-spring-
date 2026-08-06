package setec.com.lebjavaspringb.features.teacher;

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
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
@Tag(
        name = "Teacher"
//        description = "Teacher management APIs"
)
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public List<Teacher> getTeacherAll() {
        return teacherService.getTeacherAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(
            @Valid @RequestBody TeacherRequest request
    ) {
        return teacherService.createTeacher(request);
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @PutMapping("/{id}")
    public Teacher updateById(
            @PathVariable Long id,
            @Valid @RequestBody TeacherRequest request
    ) {
        return teacherService.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        teacherService.deleteById(id);
    }

    @GetMapping("/search")
    public Page<Teacher> findTeacherByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return teacherService.findTeacherByName(
                name,
                PageRequest.of(page, size)
        );
    }
}