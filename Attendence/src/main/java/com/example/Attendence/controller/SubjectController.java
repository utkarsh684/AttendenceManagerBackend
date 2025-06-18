package com.example.Attendence.controller;

import com.example.Attendence.entity.Subject;
import com.example.Attendence.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")

public class SubjectController {

    @Autowired
    private SubjectService subjectService;


    @GetMapping()
    public List<Subject> getAll(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @PutMapping("/{id}/present")
    public Subject markPresent(@PathVariable Long id){
        return subjectService.markPresent(id);
    }

    @PutMapping("/{id}/absent")
    public Subject markAbsent(@PathVariable Long id){
        return subjectService.markAbsent(id);
    }

    public void deleteDSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
    }
}
