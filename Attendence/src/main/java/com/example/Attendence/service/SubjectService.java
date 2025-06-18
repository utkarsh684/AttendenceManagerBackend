package com.example.Attendence.service;

import com.example.Attendence.entity.Subject;
import com.example.Attendence.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    @Autowired
    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject addSubject(Subject subject){
        subject.setPresent(0);
        subject.setTotal(0);
        return subjectRepository.save(subject);
    }

    public Subject markPresent(Long id){
        Subject subject= subjectRepository.findById(id).orElseThrow();
        subject.setPresent(subject.getPresent() + 1);
        subject.setTotal(subject.getTotal() + 1);
        return subjectRepository.save(subject);
    }

    public Subject markAbsent(Long id){
        Subject subject =subjectRepository.findById(id).orElseThrow();
        subject.setTotal(subject.getTotal() + 1);
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id){
        subjectRepository.deleteById(id);
    }
}
