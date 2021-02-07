package com.rdemir.personelmanagment.service;

import com.rdemir.personelmanagment.exception.ConfictExceptionHandler;
import com.rdemir.personelmanagment.model.Department;
import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.model.Personnel;
import com.rdemir.personelmanagment.repository.DepartmentRepository;
import com.rdemir.personelmanagment.repository.JobRepository;
import com.rdemir.personelmanagment.repository.PersonnelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobService {
    private final JobRepository jobRepository;
    private final PersonnelRepository personnelRepository;

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

    public boolean deleteJobById(Long id) {
        Personnel personnel = personnelRepository.findByJobId(id);
        if (personnel != null) {
            throw new ConfictExceptionHandler("You cannot delete it because it is a staff member.");
        }
        jobRepository.deleteById(id);
        return true;
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
}
