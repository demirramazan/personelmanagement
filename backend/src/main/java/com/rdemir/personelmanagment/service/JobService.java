package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ExpectationExceptionHandler;
import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.repository.JobRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {
    private final JobRepository jobRepository;

    public Job getJobByJobName(String jobName) {
        return jobRepository.findByJobName(jobName);
    }

    public List<Job> getJobList() {
        return jobRepository.findAll();
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

    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
        } catch (Exception e) {
            throw new ExpectationExceptionHandler("Silme işlemi sırasında hata olustu :" + e.getMessage());
        }
        return true;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
