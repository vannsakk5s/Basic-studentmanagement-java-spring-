package setec.com.lebjavaspringb.features.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import setec.com.lebjavaspringb.exceptions.MyResourceNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<Subject> getSubjectAll() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(SubjectRequest request) {

        Subject subject = Subject.builder()
                .subjectName(request.subjectName())
                .build();

        return subjectRepository.save(subject);
    }
    public Subject findById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() ->
                        new MyResourceNotFoundException(
                                "Subject not found with id: " + id
                        )
                );
    }

    public Subject updateById(Long id, SubjectRequest request) {

        Subject subject = findById(id);

        subject.setSubjectName(request.subjectName());

        return subjectRepository.save(subject);
    }

    public void deleteById(Long id) {
        Subject subject = findById(id);
        subjectRepository.delete(subject);
    }

    public Page<Subject> findSubjectByName(
            String name,
            Pageable pageable
    ) {
        return subjectRepository
                .findBySubjectNameContainingIgnoreCase(name, pageable);
    }
}