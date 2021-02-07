package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification,Long> {
}
