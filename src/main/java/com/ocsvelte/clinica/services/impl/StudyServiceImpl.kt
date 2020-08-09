package com.ocsvelte.clinica.services.impl

import com.ocsvelte.clinica.model.Study
import com.ocsvelte.clinica.repository.StudyRepository
import com.ocsvelte.clinica.services.StudyService
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudyServiceImpl(private val studyRepository: StudyRepository) : StudyService {
    override fun getAllStudy(): List<Study?> {
        return studyRepository.findAll()
    }

    override fun findById(studyId: Int): Optional<Study?> {
        return studyRepository.findById(studyId)
    }

    override fun save(study: Study): Study{
        return studyRepository.save(study)
    }

    override fun deleteById(studyId: Int) {
        studyRepository.deleteById(studyId)
    }
}