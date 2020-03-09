package com.project.joblist.service;

import com.project.joblist.model.Applicant;
import com.project.joblist.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    ApplicantRepository applicantRepository;

    @Override
    public void addApplicant(Applicant applicant) {
            applicantRepository.save(applicant);
    }

    @Override
    public Iterable<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant findById(int id) {
        return applicantRepository.findById(id).get();
    }

    @Override
    public void deleteApplicant(int id){ applicantRepository.deleteById(id);}
}
