package setec.com.lebjavaspringb.features.teacher;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TeacherRequest(

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

        @NotNull(message = "Salary is required")
        @DecimalMin(
                value = "0.0",
                inclusive = false,
                message = "Salary must be greater than 0"
        )
        BigDecimal salary,

        @NotBlank(message = "Phone number is required")
        String tellPhone,

        @NotBlank(message = "Subject name is required")
        String subjectName

) {
}