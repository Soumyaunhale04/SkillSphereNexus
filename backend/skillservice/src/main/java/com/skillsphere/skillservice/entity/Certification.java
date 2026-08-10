package com.skillsphere.skillservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "certifications")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Certification {

    @Id
    @GeneratedValue
    private UUID certId;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private Employee employee;

    private String name; // e.g. "AWS Solutions Architect"
    private LocalDate issued;
    private LocalDate expiry;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status { VALID, EXPIRED, PENDING_RENEWAL }
}
