package com.project.joblist.controller;

import com.project.joblist.model.Applicant;
import com.project.joblist.model.Job;
import com.project.joblist.service.ApplicantService;
import com.project.joblist.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/manager")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicantService applicantService;

    @RequestMapping(value = "")
    public String getAllJob(Model model){
        model.addAttribute("addJob", new Job());
        return "manager/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public View addJob(@ModelAttribute Job job){
        jobService.addJob(job);
        return new RedirectView("/manager");
    }

    @RequestMapping(value="/listingpage")
    public String listingPage(Model model){
        if(!model.asMap().isEmpty()) {
            int id = (int) model.asMap().get("id");
            model.addAttribute("withId",jobService.findById(id));
        }
        model.addAttribute("jobs",jobService.getAllJobs());
        return "manager/listingpage";
    }

    @RequestMapping(value = "/listingpage/delete/{id}")
    public View deleteJob(@PathVariable int id){
        jobService.deleteJob(id);
        return new RedirectView("/manager/listingpage");
    }

    @RequestMapping(value="/listingpage/{id}")
    public View findById(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("id",id);
        return new RedirectView("/manager/listingpage");
    }

    @RequestMapping(value = "/applicants")
    public String getAllApplicants(Model model) {

        if(!model.asMap().isEmpty()) {
            int id =(int)model.asMap().get("appId");
            model.addAttribute("detail", applicantService.findById(id));
        }
        model.addAttribute("applicants",applicantService.getAllApplicants());
        return "manager/applicants";
    }

    @RequestMapping(value = "/applicants/{id}")
    public View showApplicantDetails(@PathVariable int id, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("appId",id);
        return new RedirectView("/manager/applicants");
    }
    @RequestMapping(value = "/applicants/delete/{id}")
    public View deleteApplicant(@PathVariable int id){
        applicantService.deleteApplicant(id);
        return new RedirectView("/manager/applicants");
    }

    @RequestMapping(value = "/cv/{id}")
    public String showCv(@PathVariable int id, Model model){
        Applicant applicant = applicantService.findById(id);
        model.addAttribute("cv",applicant);
        return "manager/cv";
    }








}
