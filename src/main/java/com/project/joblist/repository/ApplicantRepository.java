package com.project.joblist.repository;

import com.project.joblist.model.Applicant;
import org.springframework.data.repository.CrudRepository;

public interface ApplicantRepository extends CrudRepository<Applicant, Integer> {
}
