package com.ocsvelte.clinica.services

import com.ocsvelte.clinica.model.StudySubject
import java.util.*

interface StudySubjectService {
    fun getAllStudySubjects(): List<StudySubject?>?
    fun findById(studySubjectId: Int): Optional<StudySubject?>?
    fun save(studySubject: StudySubject?): StudySubject?
    fun deleteById(studySubjectId: Int)
}