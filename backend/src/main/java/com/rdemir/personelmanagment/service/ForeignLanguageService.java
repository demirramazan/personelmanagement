package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ExpectationExceptionHandler;
import com.rdemir.personelmanagment.model.ForeignLanguage;
import com.rdemir.personelmanagment.repository.ForeignLanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ForeignLanguageService {
    private final ForeignLanguageRepository foreignLanguageRepository;

    public ForeignLanguage getForeignLanguage(Long id) {
        return foreignLanguageRepository.getOne(id);
    }

    public List<ForeignLanguage> getForeignLanguageList() {
        return foreignLanguageRepository.findAll();
    }

    public ForeignLanguage saveForeignLanguage(ForeignLanguage language) {
        return foreignLanguageRepository.save(language);
    }

    public boolean deleteExam(Long id) {
        try {
            foreignLanguageRepository.deleteById(id);
        } catch (Exception e) {
            throw new ExpectationExceptionHandler("Silme işlemi sırasında hata olustu :" + e.getMessage());
        }
        return true;
    }
}
