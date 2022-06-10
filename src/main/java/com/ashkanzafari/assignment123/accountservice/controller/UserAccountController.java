package com.ashkanzafari.assignment123.accountservice.controller;

import com.ashkanzafari.assignment123.accountservice.dto.response.AccountDto;
import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.model.Account;
import com.ashkanzafari.assignment123.accountservice.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * The endpoints for managing accounts by user
 */
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class UserAccountController {

  private final UserAccountService accountService;

  /**
   * The endpoint to get all accounts for the authenticated user
   *
   * @param principal
   * @return
   */
  @PreAuthorize("hasAuthority('ReadLev1')")
  @GetMapping(
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ApiResponse<List<Account>> getAll(Principal principal){

    List<Account> all = accountService.getAllUserAccounts(principal.getName());
    return new ApiResponse<>(all, HttpStatus.OK, "OK");
  }

  /**
   * The endpoint to validate an account by accountId
   *
   * @param accountId
   * @return
   */
  @PreAuthorize("hasAuthority('ReadLev1')")
  @GetMapping(
          path = "/{accountId}",
          consumes = MediaType.APPLICATION_JSON_VALUE,
          produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ApiResponse<AccountDto> getById(final @PathVariable String accountId){

    Optional<Account> dbAccount = accountService.getById(accountId);
    AccountDto accountDto = null;
    if(dbAccount.isPresent()){
      accountDto = new AccountDto(dbAccount.get().getId(), dbAccount.get().getUserId());
    }
    return new ApiResponse<>(accountDto, HttpStatus.OK, "OK");
  }



}
