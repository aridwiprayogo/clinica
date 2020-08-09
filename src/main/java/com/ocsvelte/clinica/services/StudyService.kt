package com.ocsvelte.clinica.services

import com.ocsvelte.clinica.model.Study
import java.util.*

interface StudyService {
    fun getAllStudy(): List<Study?>
    fun findById(studyId: Int): Optional<Study?>
    fun save(study: Study): Study
    fun deleteById(studyId: Int)
}
