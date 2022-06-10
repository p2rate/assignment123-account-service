package com.ashkanzafari.assignment123.accountservice.repository;

import com.ashkanzafari.assignment123.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

  List<Account> findAllByDeletedIsFalse();

  List<Account> findAllByUserIdAndDeletedIsFalse(String userId);

  Optional<Account> findByIdAndDeletedIsFalse(String accountId);
}