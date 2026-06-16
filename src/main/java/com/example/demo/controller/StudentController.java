package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 1. READ & SEARCH
    @GetMapping({"/students", "/"})
    public String listStudents(Model model, @Param("keyword") String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            // If they typed something in the search bar, use our custom query
            model.addAttribute("students", studentRepository.search(keyword));
            model.addAttribute("keyword", keyword); // Keeps the text in the search bar after searching
        } else {
            // Otherwise, show everyone
            model.addAttribute("students", studentRepository.findAll());
        }
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }

    // 2. CREATE/UPDATE WITH ERROR HANDLING
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        try {
            studentRepository.save(student);
            // Flash Attributes survive one redirect to show a success message
            redirectAttributes.addFlashAttribute("successMessage", "Student saved successfully!");
        } catch (DataIntegrityViolationException e) {
            // Catches Duplicate Roll Numbers!
            redirectAttributes.addFlashAttribute("errorMessage", "Error: A student with that Roll Number already exists.");
            return "redirect:/students/new";
        }
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow();
        model.addAttribute("student", student);
        return "create_student";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        studentRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Student deleted successfully.");
        return "redirect:/students";
    }
    
 // 6. LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login"; // Returns the login.html page
    }
}