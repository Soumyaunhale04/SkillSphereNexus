package com.skillsphere.skillservice.service;

import com.skillsphere.skillservice.dto.RenewalDTO;
import com.skillsphere.skillservice.entity.Certification;
import com.skillsphere.skillservice.entity.CertificationRenewal;
import com.skillsphere.skillservice.repository.CertificationRenewalRepository;
import com.skillsphere.skillservice.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class RenewalService {
    private final CertificationRepository certificationRepository;
    private final CertificationRenewalRepository renewalRepository;
    private final CertificationAuditService auditService;


    public RenewalDTO requestRenewal(UUID certificationId, String requestedBy) {
        Certification cert = certificationRepository.findById(certificationId).orElseThrow(() ->
                                new RuntimeException("Certification not found"));
        CertificationRenewal renewal = CertificationRenewal.builder()
                        .certification(cert)
                        .oldExpiry(cert.getExpiry())
                        .status(CertificationRenewal.RenewalStatus.REQUESTED)
                        .requestedBy(requestedBy)
                        .requestedAt(LocalDateTime.now())
                        .build();
        CertificationRenewal saved = renewalRepository.save(renewal);
        auditService.log(cert.getCertId(), cert.getEmployee().getEmpId(),
                "RENEWAL_REQUESTED", requestedBy);
        return toDTO(saved);
    }

    public RenewalDTO approveRenewal(UUID renewalId, LocalDate newExpiry, String approvedBy) {
        CertificationRenewal renewal = renewalRepository.findById(renewalId).orElseThrow(() ->
                                new RuntimeException("Renewal not found"));
        Certification cert = renewal.getCertification();
        cert.setExpiry(newExpiry);
        cert.setStatus(Certification.Status.VALID);

        certificationRepository.save(cert);

        renewal.setNewExpiry(newExpiry);
        renewal.setApprovedBy(approvedBy);
        renewal.setApprovedAt(LocalDateTime.now());
        renewal.setStatus(CertificationRenewal.RenewalStatus.APPROVED);

        CertificationRenewal saved = renewalRepository.save(renewal);
        auditService.log(cert.getCertId(), cert.getEmployee().getEmpId(),
                "RENEWED", approvedBy);

        return toDTO(saved);
    }


    private RenewalDTO toDTO(CertificationRenewal renewal) {
        return RenewalDTO.builder()
                .renewalId(renewal.getRenewalId())
                .certificationId(renewal.getCertification().getCertId())
                .oldExpiry(renewal.getOldExpiry())
                .newExpiry(renewal.getNewExpiry())
                .status(renewal.getStatus().name())
                .requestedBy(renewal.getRequestedBy())
                .approvedBy(renewal.getApprovedBy())
                .build();
    }
}