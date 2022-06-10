package com.ashkanzafari.assignment123.accountservice.model;

import com.ashkanzafari.assignment123.accountservice.model.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Permission.
 *
 * <p>Class to persist what permissions each Role has</p>
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends Auditable implements Serializable {

  @Builder.Default
  private static final long serialVersionUID = 1L;

  @NotNull
  @NotEmpty
  private String userId;

  @Column(name = "current_account", nullable = false, columnDefinition = "boolean default false")
  private boolean currentAccount;

  private String billingAddress;

  public Account(String userId, String billingAddress, boolean currentAccount){
    this.userId = userId;
    this.billingAddress = billingAddress;
    this.currentAccount = currentAccount;
  }
}
