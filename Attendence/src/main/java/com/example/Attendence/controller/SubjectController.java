package com.example.Attendence.controller;

import com.example.Attendence.dto.AttendenceRequest;
import com.example.Attendence.dto.SubjectSummaryDTO;
import com.example.Attendence.entity.Subject;
import com.example.Attendence.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping("/{id}/delete")
    public void deleteSubject(@PathVariable Long id){

        subjectService.deleteSubject(id);
    }

    @GetMapping("/summary")
    public List<SubjectSummaryDTO> getSubjectSummary() {
        return subjectService.getSubjectSummaries();
    }

    @PostMapping("/attendence")
    public ResponseEntity<String> markAttendence(@RequestBody AttendenceRequest request){
        String subjectName= request.getName();
        String status= request.getStatus();
        Subject subject = subjectService.getSubjectByName(subjectName);

        if (subject == null) {
            return ResponseEntity.badRequest().body("Subject not found");
        }

        subject.setTotal(subject.getTotal()+1);
        if(status=="present"){
            subject.setPresent(subject.getPresent()+1);
        }

        subjectService.saveSubject(subject);

        return ResponseEntity.ok("Attendance marked as " + status);
    }

}
