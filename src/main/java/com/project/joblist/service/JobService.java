package com.project.joblist.service;

import com.project.joblist.model.Job;

public interface JobService {


     Iterable<Job> getAllJobs();
     void addJob(Job job);
     void deleteJob(int id);
     Job findById(int id);




}
