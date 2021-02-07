package com.rdemir.personelmanagment.rest;

import com.rdemir.personelmanagment.model.Job;
import com.rdemir.personelmanagment.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
@Api(value = "Job Api Rests")
@AllArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/all")
    @ApiOperation(value = "Get All Jobs")
    public ResponseEntity<List<Job>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/find/{id}")
    @ApiOperation(value = "Get One Job")
    public ResponseEntity<Job> getJob(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @PostMapping("/save")
    @ApiOperation(value = "Save One Job")
    public ResponseEntity<Job> saveJob(@RequestBody Job job) {
        return ResponseEntity.ok(jobService.saveJob(job));
    }
    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete One Job")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.deleteJobById(id));
    }
}
