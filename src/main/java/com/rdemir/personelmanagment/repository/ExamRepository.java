package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Long> {
}
