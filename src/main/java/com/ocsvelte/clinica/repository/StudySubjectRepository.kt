package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.StudySubject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudySubjectRepository : JpaRepository<StudySubject?, Int?> 