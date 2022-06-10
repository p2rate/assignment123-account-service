package com.ashkanzafari.assignment123.accountservice.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateAccountRequest {

  @NotNull
  @NotEmpty
  private String customerId;

  @NotNull
  private Double initialCredit;

  private String billingAddress;
}
