package com.ocsvelte.clinica.controller;

import com.ocsvelte.clinica.exception.ResourceNotFoundException;
import com.ocsvelte.clinica.model.StudySubject;
import com.ocsvelte.clinica.services.impl.StudySubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudySubjectController {

    StudySubjectServiceImpl studySubjectServiceImpl;

    @Autowired
    public StudySubjectController(StudySubjectServiceImpl studySubjectServiceImpl) {
        this.studySubjectServiceImpl = studySubjectServiceImpl;
    }

    @GetMapping(value = "/participant")
    public List<StudySubject> getAllStudySubjects() {
        return studySubjectServiceImpl.getAllStudySubjects();
    }

    @GetMapping(value = "/participant/{studySubjectId}")
    public StudySubject getStudySubjectId(@PathVariable("studySubjectId") int studySubjectId) {
        StudySubject studySubject = studySubjectServiceImpl.findById(studySubjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Study subject " + studySubjectId + " not found"));

        return studySubject;
    }

    @PostMapping(value = "/participant")
    public StudySubject addStudySubject(@RequestBody StudySubject studySubject) {
        return studySubjectServiceImpl.save(studySubject);
    }

    @PutMapping(value = "/participant")
    public StudySubject updateStudySubject(@PathVariable("studySubjectId") int studySubjectId, @RequestBody StudySubject studySubject) {
        StudySubject studySubjectUpdate = studySubjectServiceImpl.findById(studySubjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Study subject " + studySubjectId + " not found"));

        //need update
        return studySubjectServiceImpl.save(studySubjectUpdate);
    }

    @DeleteMapping(value = "/participant/{studySubjectId}")
    public String deleteStudySubject(@PathVariable("studySubjectId") int studySubjectId) {
        StudySubject studySubject = studySubjectServiceImpl.findById(studySubjectId)
                .orElseThrow(() -> new ResourceNotFoundException("Study subject " + studySubjectId + " not found"));

        studySubjectServiceImpl.deleteById(studySubject.getStudySubjectId());
        return "Study subject with ID = " + studySubjectId + " deleted";
    }
}
