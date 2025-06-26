package com.laszlo.todoapp.service;

import java.util.List; // New import
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; // New import
import org.springframework.stereotype.Service;

import com.laszlo.todoapp.model.Subject;
import com.laszlo.todoapp.repository.SubjectRepository;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository; // Initialize new dependency
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}