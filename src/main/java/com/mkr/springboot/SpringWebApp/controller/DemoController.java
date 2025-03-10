package com.mkr.springboot.SpringWebApp.controller;
import com.mkr.springboot.SpringWebApp.Service.MailService;
import com.mkr.springboot.SpringWebApp.Service.StudentService;
import com.mkr.springboot.SpringWebApp.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/students")
public class DemoController {

    private StudentService studentService;
    private MailService mailService;

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired // @Autowired annotation tells Spring to inject a dependency
    public DemoController(StudentService studentService, MailService mailService) {
        this.studentService = studentService;
        this.mailService = mailService;
       }


    @GetMapping("/admission")
    public String admissionForm(Model theModel){
        // create Model attribute to bind form data
        Student student = new Student();
        theModel.addAttribute("student", student);
        return "Admission";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent) throws IOException {
        // save the employee
        studentService.save(theStudent);
        // Send An Email
       // mailService.sendMail("studentdody330@gmail.com");
        return "redirect:/students/list";

    }

    @GetMapping("/list")
    public String getAllStudents(Model theModel){

        List<Student> theStudents = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("theStudents", theStudents);

        return "students-list";
    }

    @GetMapping("/ShowUpdateForm")
    public String ShowUpdateForm(@RequestParam("studentId") int id, Model theModel){
        Student student = studentService.findById(id);
        theModel.addAttribute("student", student);
        return "Admission";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel){
        // get the employee from the service
        Student thestudent = studentService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("student", thestudent);
        logger.info("in update for "+ theId);
        //logger.info(thestudent.toString());

        // send over to our form
        return "Admission";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int theId){
        studentService.deleteById(theId);
        return "redirect:/students/list";
    }
}
