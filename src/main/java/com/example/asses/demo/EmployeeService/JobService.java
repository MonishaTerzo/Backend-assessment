package com.example.asses.demo.EmployeeService;

import com.example.asses.demo.model.Job;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface JobService {

    List<Job> getAllJobs();

    Job getJobById(Long id);

    Job createJob(Job job);

    Job updateJob(Long id, Job job);

    void deleteJob(Long id);
}
