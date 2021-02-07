package com.rdemir.personelmanagment.repository;

import com.rdemir.personelmanagment.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
    Job findByJobName(String jobName);
}
