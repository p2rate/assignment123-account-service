package com.ashkanzafari.assignment123.accountservice.feign.model.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class Transaction {

  private String fromAccount;

  private String toAccount;

  private TransactionType transactionType;

  private Double amount;

}

