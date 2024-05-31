package com.springboot.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.example.Branch;
import com.springboot.example.Service;

@Controller
public class MyController {
	
	public List<Branch> getBranches() {
        return Arrays.asList(
            new Branch("Bengaluru Branch 1", "123 MG Road, Bengaluru"),
            new Branch("Bengaluru Branch 2", "456 Brigade Road, Bengaluru"),
            new Branch("Bengaluru Branch 3", "789 Koramangala, Bengaluru"),
            new Branch("Bengaluru Branch 4", "321 Indiranagar, Bengaluru"),
            new Branch("Bengaluru Branch 5", "654 Whitefield, Bengaluru"),
            new Branch("Bengaluru Branch 6", "987 Electronic City, Bengaluru"),
            new Branch("Bengaluru Branch 7", "543 Jayanagar, Bengaluru"),
            new Branch("Bengaluru Branch 8", "210 Rajajinagar, Bengaluru"),
            new Branch("Bengaluru Branch 9", "876 HSR Layout, Bengaluru"),
            new Branch("Bengaluru Branch 10", "345 BTM Layout, Bengaluru")
        );
    }
	
	List<Service> services = Arrays.asList(
            new Service("Checking Account", "Provides easy access to funds with a debit card"),
            new Service("Savings Account", "Offers interest on the saved amount"),
            new Service("Loan Services", "Various loan options for personal and business needs"),
            new Service("Credit Card", "Credit cards with various reward programs"),
            new Service("Investment Services", "Helps in making informed investment decisions")
        );

      
	
	@RequestMapping("/bank-branches")
	public String showBranches(Model model) {
		
		List<Branch> branches=getBranches();
		model.addAttribute("branches", branches);
		return "branch";
	}
	
	
	@RequestMapping("/bank-service")
	public String viewServices(Model model) {
		model.addAttribute("services", services);
		return "service";
	}


}
