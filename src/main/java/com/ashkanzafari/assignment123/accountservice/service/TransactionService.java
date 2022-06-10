package com.ashkanzafari.assignment123.accountservice.service;

import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.exception.DepositUnsuccessfulException;
import com.ashkanzafari.assignment123.accountservice.feign.TransactionClient;
import com.ashkanzafari.assignment123.accountservice.feign.model.request.DepositRequestDto;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.Balance;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.DepositResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionClient transactionClient;


  public void deposit(DepositRequestDto depositRequestDto) throws DepositUnsuccessfulException {

    ApiResponse<DepositResponseDto> deposit = transactionClient.deposit(depositRequestDto);
    if(deposit.getPayload() == null){
      throw new DepositUnsuccessfulException();
    }
  }

  public Balance getAccountInfo(final String accountId){

    ApiResponse<Balance> accountInfo = transactionClient.getAccountInfo(accountId);
    return accountInfo.getPayload();
  }
}
