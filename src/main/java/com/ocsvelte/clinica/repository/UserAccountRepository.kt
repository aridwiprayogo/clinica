package com.ocsvelte.clinica.repository

import com.ocsvelte.clinica.model.UserAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserAccountRepository : JpaRepository<UserAccount?, Int?> 