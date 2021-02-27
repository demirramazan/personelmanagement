package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ExpectationExceptionHandler;
import com.rdemir.personelmanagment.model.Exam;
import com.rdemir.personelmanagment.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    public Exam getExam(Long id) {
        return examRepository.getOne(id);
    }

    public List<Exam> getExamsList() {
        return examRepository.findAll();
    }

    public Exam saveExam(Exam exam) {
        return examRepository.save(exam);
    }

    public boolean deleteExam(Long id) {
        try {
            examRepository.deleteById(id);
        } catch (Exception e) {
            throw new ExpectationExceptionHandler("Silme işlemi sırasında hata olustu :" + e.getMessage());
        }
        return true;
    }
}
