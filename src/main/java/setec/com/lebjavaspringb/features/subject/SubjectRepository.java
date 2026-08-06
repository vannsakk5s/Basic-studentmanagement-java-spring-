package setec.com.lebjavaspringb.features.subject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Page<Subject> findBySubjectNameContainingIgnoreCase(
            String subjectName,
            Pageable pageable
    );
}