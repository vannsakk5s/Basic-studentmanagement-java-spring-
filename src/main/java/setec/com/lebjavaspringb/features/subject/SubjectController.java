package setec.com.lebjavaspringb.features.subject;

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
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
@Tag(
        name = "Subject"
//        description = "Subject management APIs"
)
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjectAll() {
        return subjectService.getSubjectAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subject createSubject(
            @Valid @RequestBody SubjectRequest request
    ) {
        return subjectService.createSubject(request);
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @PutMapping("/{id}")
    public Subject updateById(
            @PathVariable Long id,
            @Valid @RequestBody SubjectRequest request
    ) {
        return subjectService.updateById(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        subjectService.deleteById(id);
    }

    @GetMapping("/search")
    public Page<Subject> findSubjectByName(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return subjectService.findSubjectByName(
                name,
                PageRequest.of(page, size)
        );
    }
}