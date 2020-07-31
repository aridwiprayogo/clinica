package com.ocsvelte.clinica.services;

import com.ocsvelte.clinica.model.StudySubject;
import com.ocsvelte.clinica.model.UserAccount;
import org.apache.catalina.User;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    List<UserAccount> getAllUserAccount();

    Optional<UserAccount> findById(int userId);

    UserAccount save(UserAccount userAccount);

    void deleteById(int userId);
}
