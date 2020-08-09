package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.Study
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StudyRepository : JpaRepository<Study?, Int?> 