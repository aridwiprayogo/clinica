package com.ocsvelte.clinica.services;

import com.ocsvelte.clinica.model.StudySubject;
import com.ocsvelte.clinica.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    List<Subject> getAllSubjects();

    Optional<Subject> findById(int subjectId);

    Subject save(Subject subject);

    void deleteById(int subjectId);
}
