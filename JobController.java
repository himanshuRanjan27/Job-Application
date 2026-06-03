package com.telusko.JobApp.controller;

import com.telusko.JobApp.model.JobPost;
import com.telusko.JobApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JobController {

    // controller talking to service
    @Autowired
    private JobService service;


    // two urls are getting connected
    @GetMapping({"/", "home"})
    public String home() {
        return "home";//reffering to the home.jsp
    }


    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }


    // use of post mapping because it is submitting data not getting
    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        service.addJob(jobPost);
        return "success";

    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }

}