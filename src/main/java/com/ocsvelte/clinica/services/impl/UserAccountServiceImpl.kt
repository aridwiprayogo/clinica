package com.ocsvelte.clinica.services.impl

import com.ocsvelte.clinica.model.UserAccount
import com.ocsvelte.clinica.repository.UserAccountRepository
import com.ocsvelte.clinica.services.UserAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
open class UserAccountServiceImpl : UserAccountService {
    @Autowired
    lateinit var userAccountRepository: UserAccountRepository
    override fun getAllUserAccount(): List<UserAccount?> = userAccountRepository.findAll()

    override fun findById(userId: Int): Optional<UserAccount?> {
        return userAccountRepository.findById(userId)
    }

    override fun save(userAccount: UserAccount): UserAccount {
        return userAccountRepository.save(userAccount)
    }

    override fun deleteById(userId: Int) {
        userAccountRepository.deleteById(userId)
    }
}