package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ExpectationExceptionHandler;
import com.rdemir.personelmanagment.model.Education;
import com.rdemir.personelmanagment.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationService {
    private final EducationRepository educationRepository;

    public Education getEducation(Long id) {
        return educationRepository.getOne(id);
    }

    public List<Education> getEducationList() {
        return educationRepository.findAll();
    }

    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }

    public boolean deleteEducation(Long id) {
        try {
            educationRepository.deleteById(id);
        } catch (Exception e) {
            throw new ExpectationExceptionHandler("Silme işlemi sırasında hata olustu :" + e.getMessage());
        }
        return true;
    }
}
