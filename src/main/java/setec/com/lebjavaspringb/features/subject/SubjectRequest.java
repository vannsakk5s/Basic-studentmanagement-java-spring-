package setec.com.lebjavaspringb.features.subject;

import jakarta.validation.constraints.NotBlank;

public record SubjectRequest(

        @NotBlank(message = "Subject name is required")
        String subjectName

) {
}