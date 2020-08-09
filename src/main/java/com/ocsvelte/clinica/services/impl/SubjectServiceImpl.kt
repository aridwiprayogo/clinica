package com.ocsvelte.clinica.services.impl

import com.ocsvelte.clinica.model.Subject
import com.ocsvelte.clinica.repository.SubjectRepository
import com.ocsvelte.clinica.services.SubjectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
open class SubjectServiceImpl : SubjectService {
    @Autowired
    lateinit var subjectRepository: SubjectRepository

    override fun getAllSubjects(): List<Subject?> = subjectRepository.findAll()

    override fun findById(subjectId: Int): Optional<Subject?> {
        return subjectRepository.findById(subjectId)
    }

    override fun save(subject: Subject): Subject {
        return subjectRepository.save(subject)
    }

    override fun deleteById(subjectId: Int) {
        subjectRepository.deleteById(subjectId)
    }
}