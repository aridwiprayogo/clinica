package com.ocsvelte.clinica.services

import com.ocsvelte.clinica.model.Subject
import java.util.*

interface SubjectService {
    fun getAllSubjects(): List<Subject?>
    fun findById(subjectId: Int): Optional<Subject?>
    fun save(subject: Subject): Subject
    fun deleteById(subjectId: Int)
}