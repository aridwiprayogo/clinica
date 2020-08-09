package com.ocsvelte.clinica.services.impl

import com.ocsvelte.clinica.model.StudySubject
import com.ocsvelte.clinica.repository.StudySubjectRepository
import com.ocsvelte.clinica.services.StudySubjectService
import org.springframework.stereotype.Service
import java.util.*

@Service
open class StudySubjectServiceImpl(private val studySubjectRepository: StudySubjectRepository) : StudySubjectService {
    override fun getAllStudySubjects(): List<StudySubject?> = studySubjectRepository.findAll()

    override fun findById(studySubjectId: Int): Optional<StudySubject?>? = studySubjectRepository.findById(studySubjectId)

    override fun save(studySubject: StudySubject?): StudySubject? = studySubjectRepository.save(studySubject!!)

    override fun deleteById(studySubjectId: Int) {
        studySubjectRepository.deleteById(studySubjectId)
    }

}