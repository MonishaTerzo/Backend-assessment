package com.example.asses.demo.EmployeeService.impl;

import com.example.asses.demo.EmployeeRepository.JobRepository;
import com.example.asses.demo.EmployeeService.JobService;
import com.example.asses.demo.model.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    @Override
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    public Job updateJob(Long id, Job job) {
        Job existingJob = getJobById(id);
        existingJob.setJoining_date(job.getJoining_date());
        existingJob.setEmployee_status(job.getEmployee_status());
        existingJob.setEmployee_type(job.getEmployee_type());
        existingJob.setJobtitle(job.getJobtitle());
        existingJob.setPerformance(job.getPerformance());
        return jobRepository.save(existingJob);
    }

    @Override
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
