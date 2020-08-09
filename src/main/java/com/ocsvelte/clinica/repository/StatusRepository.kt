package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.Status
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository : JpaRepository<Status?, Int?> 