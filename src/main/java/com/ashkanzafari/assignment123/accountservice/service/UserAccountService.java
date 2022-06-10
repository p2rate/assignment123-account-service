package com.ashkanzafari.assignment123.accountservice.service;

import com.ashkanzafari.assignment123.accountservice.model.Account;
import com.ashkanzafari.assignment123.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer methods for managing accounts
 */
@Service
@RequiredArgsConstructor
public class UserAccountService {

  private final AccountRepository accountRepository;


  /**
   * The service layer method to get all accounts of the specified user
   * @param userId
   * @return
   */
  public List<Account> getAllUserAccounts(String userId) {

    return accountRepository.findAllByUserIdAndDeletedIsFalse(userId);
  }

  /**
   * Service layer method to get an account by accountId
   *
   * @param accountId
   * @return
   */
  public Optional<Account> getById(String accountId) {

    return accountRepository.findByIdAndDeletedIsFalse(accountId);
  }
}
