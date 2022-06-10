package com.ashkanzafari.assignment123.accountservice.controller;

import com.ashkanzafari.assignment123.accountservice.dto.request.CreateAccountRequest;
import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.model.Account;
import com.ashkanzafari.assignment123.accountservice.service.OperatorAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * The endpoints for managing accounts used by admin
 *
 */
@RestController
@RequestMapping("/api/admin/v1/account")
@RequiredArgsConstructor
public class OperatorAccountController {

  private final OperatorAccountService accountService;

  /**
   *The endpoint to be used by operator to get all accounts
   *
   * @return
   */
  @PreAuthorize("hasAuthority('ReadLev2')")
  @GetMapping
  public ApiResponse<List<Account>> getAll(){

    List<Account> all = accountService.getAll();
    return new ApiResponse<>(all, HttpStatus.OK, "OK");
  }

  /**
   * The endpoint to be used by operator to open new account link to a user
   *
   * @param createAccountRequest
   * @return
   */
  @PreAuthorize("hasAuthority('WriteLev2')")
  @PostMapping
  public ApiResponse<Account> create(@RequestBody @Valid CreateAccountRequest createAccountRequest){

    Account newAccount = accountService.add(createAccountRequest);
    return new ApiResponse<>(newAccount, HttpStatus.OK, "OK");
  }



}
