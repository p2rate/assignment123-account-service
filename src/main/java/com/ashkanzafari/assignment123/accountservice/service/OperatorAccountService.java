package com.ashkanzafari.assignment123.accountservice.service;

import com.ashkanzafari.assignment123.accountservice.dto.request.CreateAccountRequest;
import com.ashkanzafari.assignment123.accountservice.exception.UserNotExistsException;
import com.ashkanzafari.assignment123.accountservice.feign.model.request.DepositRequestDto;
import com.ashkanzafari.assignment123.accountservice.model.Account;
import com.ashkanzafari.assignment123.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer methods for managing accounts used by operator
 */
@Service
@RequiredArgsConstructor
public class OperatorAccountService {

  private final AccountRepository accountRepository;
  private final UserService userService;
  private final TransactionService transactionService;

  /**
   * Service layer method to get all users
   *
   * @return
   */
  public List<Account> getAll() {
    return accountRepository.findAllByDeletedIsFalse();
  }

  /**
   * Service layer method to create a new account, link it to the requested user and set it as
   * current account for the user
   *
   * @param createAccountRequest
   * @return
   */
  public Account add(CreateAccountRequest createAccountRequest) throws UserNotExistsException {

    // validate if user exists querying user-service
    userService.validateUser(createAccountRequest.getCustomerId());

    Account newAccount = new Account(createAccountRequest.getCustomerId(),
            createAccountRequest.getBillingAddress(), true);

    List<Account> previousAccounts = accountRepository.findAllByUserIdAndDeletedIsFalse(
            createAccountRequest.getCustomerId());
    previousAccounts.stream().forEach(account -> account.setCurrentAccount(false));

    accountRepository.saveAll(previousAccounts);
    Account savedAccount = accountRepository.save(newAccount);

    //if initialCredit is not zero sent a request to transaction-service to deposit the amount
    if (createAccountRequest.getInitialCredit() > 0) {
      transactionService.deposit(new DepositRequestDto(savedAccount.getId(), createAccountRequest.getInitialCredit()));
    }

    return savedAccount;
  }

}
