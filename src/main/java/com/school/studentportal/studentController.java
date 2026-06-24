package com.school.studentportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class studentController {

    @Autowired
    private StudentRepository studentRepository;

    // Show login page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Handle login form submission
    @PostMapping("/login")
    public String login(@RequestParam String matNo, Model model) {
        Optional<Student> studentOpt = studentRepository.findById(matNo);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            model.addAttribute("student", student);
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid Matric Number");
            return "login";
        }
    }
}
