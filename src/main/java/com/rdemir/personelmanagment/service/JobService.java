package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import com.rdemir.personelmanagment.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public Job getJobByJobName(String jobName) {
        return jobRepository.findByJobName(jobName);
    }

    public Job getJobById(Long id) {
        Optional<Job> job = jobRepository.findById(id);
        return job.orElse(null);
    }

    public Job saveJob(Job job) {
        Job job1 = getJobByJobName(job.getJobName());
        if (job1 != null)
            return job1;

        return jobRepository.save(job);
    }
}
