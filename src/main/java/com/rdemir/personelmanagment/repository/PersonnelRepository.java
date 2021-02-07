package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelRepository extends JpaRepository<Personnel,Long> {
    Personnel findByDepartmentId(Long id);

    Personnel findByJobId(Long id);
}
