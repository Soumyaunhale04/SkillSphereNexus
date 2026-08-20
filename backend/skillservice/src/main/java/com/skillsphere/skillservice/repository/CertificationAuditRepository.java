package com.skillsphere.skillservice.repository;
import com.skillsphere.skillservice.entity.CertificationAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;
public interface CertificationAuditRepository extends JpaRepository<CertificationAudit, UUID> {
    List<CertificationAudit>
    findByCertificationIdOrderByPerformedAtDesc(
            UUID certificationId);
}