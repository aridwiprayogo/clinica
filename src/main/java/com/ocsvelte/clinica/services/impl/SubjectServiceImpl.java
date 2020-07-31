package com.ocsvelte.clinica.services.impl;

import com.ocsvelte.clinica.model.Subject;
import com.ocsvelte.clinica.repository.SubjectRepository;
import com.ocsvelte.clinica.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(int subjectId) {
        return subjectRepository.findById(subjectId);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(int subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
