package com.project.joblist.service;

import com.project.joblist.model.Applicant;

public interface ApplicantService {

     void addApplicant(Applicant applicant);
     Iterable<Applicant> getAllApplicants();
     Applicant findById(int id);
     void deleteApplicant(int id);

}
