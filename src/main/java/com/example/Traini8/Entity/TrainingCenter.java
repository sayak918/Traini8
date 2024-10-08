package com.example.Traini8.Entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainingCenter")
public class
TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 40)
    @NotBlank(message = "Center Name is required")
    private String centerName;

    @NotBlank(message = "Center Code is required ")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
    private String centerCode;


    @Valid
    @NotNull(message = "Address is required")
    @Embedded
    private Address address;

    @Positive(message = "Capacity must be positive")
    private Integer studentCapacity;

    @ElementCollection
    @CollectionTable(name = "training_center_courses", joinColumns = @JoinColumn(name = "training_center_id"))
    @Column(name = "course_name")
    private List<String> coursesOffered;

    @Column(nullable = false)
    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact phone must be a valid 10-digit number")
    private String contactPhone;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now().getEpochSecond();
    }

}
