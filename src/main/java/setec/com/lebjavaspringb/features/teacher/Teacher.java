package setec.com.lebjavaspringb.features.teacher;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "teachers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotNull(message = "Date of birth is required")
    private LocalDate dob;

    @NotBlank(message = "Address is required")
    private String address;

    @NotNull(message = "Salary is required")
    @DecimalMin(
            value = "0.0",
            inclusive = false,
            message = "Salary must be greater than 0"
    )
    private BigDecimal salary;

    @NotBlank(message = "Phone number is required")
    @Column(unique = true)
    private String tellPhone;

    @NotBlank(message = "Subject name is required")
    private String subjectName;
}