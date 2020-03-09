package com.project.joblist.controller;


import com.project.joblist.model.Applicant;
import com.project.joblist.service.ApplicantService;
import com.project.joblist.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    JobService jobService;
    @Autowired
    ApplicantService applicantService;

    @RequestMapping("")
    public String getAllJob(Model model){
        if(!model.asMap().isEmpty())
            model.addAttribute("jobId",jobService.findById((int)model.asMap().get("id")));
        model.addAttribute("jobs",jobService.getAllJobs());
        model.addAttribute("applicant", new Applicant());
        return "home";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public View AddApplication(@ModelAttribute Applicant applicant, @RequestParam("file")MultipartFile multipartFile){
        try {
            String resumeBase64 = Base64.getEncoder().encodeToString(multipartFile.getBytes());
            applicant.setResumeName(multipartFile.getOriginalFilename());
            applicant.setResume(resumeBase64);
        } catch (IOException e) {
            e.printStackTrace();
        }
        applicantService.addApplicant(applicant);
        return new RedirectView("/");
    }

    @RequestMapping(value="/list/{id}")
    public View listDetails(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("id",id);
        return new RedirectView("/");
    }
}
