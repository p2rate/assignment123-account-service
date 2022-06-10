package com.ashkanzafari.assignment123.accountservice.feign.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositRequestDto {

  private String toAccount;
  private Double amount;
}
