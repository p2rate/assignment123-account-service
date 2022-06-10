package com.ashkanzafari.assignment123.accountservice.feign.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Balance {


  private String account;
  private Double balance;
  private Set<Transaction> transactions;

}
