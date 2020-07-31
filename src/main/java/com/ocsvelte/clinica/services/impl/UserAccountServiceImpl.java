package com.ocsvelte.clinica.services.impl;

import com.ocsvelte.clinica.model.UserAccount;
import com.ocsvelte.clinica.repository.UserAccountRepository;
import com.ocsvelte.clinica.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public List<UserAccount> getAllUserAccount() {
        return userAccountRepository.findAll();
    }

    @Override
    public Optional<UserAccount> findById(int userId) {
        return userAccountRepository.findById(userId);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public void deleteById(int userId) {
        userAccountRepository.deleteById(userId);
    }
}
