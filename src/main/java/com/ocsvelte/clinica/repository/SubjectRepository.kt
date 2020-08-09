package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.Subject
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<Subject?, Int?> 