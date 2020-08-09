package com.ocsvelte.clinica.services

import com.ocsvelte.clinica.model.UserAccount
import java.util.*

interface UserAccountService {
    fun getAllUserAccount(): List<UserAccount?>
    fun findById(userId: Int): Optional<UserAccount?>
    fun save(userAccount: UserAccount): UserAccount
    fun deleteById(userId: Int)
}