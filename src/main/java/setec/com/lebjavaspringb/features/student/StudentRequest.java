package setec.com.lebjavaspringb.features.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StudentRequest(

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Gender is required")
        String gender,

        @NotNull(message = "Date of birth is required")
        LocalDate dob,

        @NotBlank(message = "Address is required")
        String address,

        @Email(message = "Email is invalid")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Subject name is required")
        String subjectName
) {
}