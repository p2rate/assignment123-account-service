package com.ashkanzafari.assignment123.accountservice.controller;

import com.ashkanzafari.assignment123.accountservice.dto.response.AccountDto;
import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.dto.response.InfoDto;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.Balance;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.User;
import com.ashkanzafari.assignment123.accountservice.model.Account;
import com.ashkanzafari.assignment123.accountservice.service.TransactionService;
import com.ashkanzafari.assignment123.accountservice.service.UserAccountService;
import com.ashkanzafari.assignment123.accountservice.service.UserService;
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
import java.util.stream.Collectors;

/**
 * The endpoints for accessing all user info
 */
@RestController
@RequestMapping("/api/v1/info")
@RequiredArgsConstructor
public class UserInfoController {

  private final UserService userService;
  private final UserAccountService userAccountService;
  private final TransactionService transactionService;

  @PreAuthorize("hasAuthority('ReadLev1')")
  @GetMapping
  public ApiResponse<InfoDto> getInfo(final Principal principal){

    User authenticatedUserInfo = userService.getAuthenticatedUserInfo();
    List<Account> allUserAccounts = userAccountService.getAllUserAccounts(principal.getName());

    List<Balance> accountsInfo = allUserAccounts.stream()
            .map(
                    account -> transactionService.getAccountInfo(account.getId()))
            .collect(Collectors.toList());

    InfoDto infoDto = new InfoDto(authenticatedUserInfo, accountsInfo);
    return new ApiResponse<>(infoDto, HttpStatus.OK, "OK");
  }



}
