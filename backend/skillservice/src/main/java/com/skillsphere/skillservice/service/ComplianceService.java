package com.skillsphere.skillservice.service;
import com.skillsphere.skillservice.dto.ComplianceDTO;
import com.skillsphere.skillservice.entity.Certification;
import com.skillsphere.skillservice.entity.Employee;
import com.skillsphere.skillservice.repository.CertificationRepository;
import com.skillsphere.skillservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class ComplianceService {
    private final EmployeeRepository employeeRepository;
    private final CertificationRepository certificationRepository;

    public ComplianceDTO getCompliance(UUID empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() ->new RuntimeException(
                                        "Employee not found"));
        List<Certification> certifications = certificationRepository.findByEmployeeEmpId(empId);
        long total = certifications.size();
        long expired = certifications.stream().filter(c -> c.getStatus() == Certification.Status.EXPIRED)
                        .count();
        long valid = certifications.stream().filter(c ->c.getStatus() == Certification.Status.VALID)
                        .count();
        return ComplianceDTO.builder()
                .employeeName(employee.getName())
                .totalCertifications(total)
                .validCertifications(valid)
                .expiredCertifications(expired)
                .compliant(total > 0 && expired == 0)
                .build();
    }
}