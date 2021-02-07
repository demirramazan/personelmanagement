package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Education;
import com.rdemir.personelmanagment.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Long> {
}
