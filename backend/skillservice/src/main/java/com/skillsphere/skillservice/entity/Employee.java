
package com.skillsphere.skillservice.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

    @Entity
    @Table(name = "employees")
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public class Employee {

        @Id
        @GeneratedValue
        private UUID empId;

        @Column(nullable = false)
        private String name;

        @Enumerated(EnumType.STRING)
        private Role role;

        private String department;

        public enum Role { DEVELOPER, MANAGER, TECH_LEAD, HR, ADMIN, TRAINING_MANAGER }
}
