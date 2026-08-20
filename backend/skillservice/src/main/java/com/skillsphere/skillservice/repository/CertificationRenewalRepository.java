package com.skillsphere.skillservice.repository;
import com.skillsphere.skillservice.entity.CertificationRenewal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;
public interface CertificationRenewalRepository extends JpaRepository<CertificationRenewal, UUID> {
    List<CertificationRenewal> findByCertificationCertId(UUID certificationId);
}