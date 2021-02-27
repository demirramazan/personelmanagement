package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ExpectationExceptionHandler;
import com.rdemir.personelmanagment.model.Certification;
import com.rdemir.personelmanagment.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public Certification getCertification(Long id) {
        return certificationRepository.getOne(id);
    }

    public List<Certification> getCertificationList() {
        return certificationRepository.findAll();
    }

    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public boolean deleteCertification(Long id) {
        try {
            certificationRepository.deleteById(id);
        } catch (Exception e) {
            throw new ExpectationExceptionHandler("Silme işlemi sırasında hata olustu :" + e.getMessage());
        }
        return true;
    }
}
