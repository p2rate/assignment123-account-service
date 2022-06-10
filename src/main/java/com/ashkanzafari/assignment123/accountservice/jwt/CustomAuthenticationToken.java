package com.ashkanzafari.assignment123.accountservice.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

  private String originalToken;

  public CustomAuthenticationToken(Object principal, Object credentials,
  Collection<? extends GrantedAuthority> authorities, String originalToken){
    super(principal, credentials, authorities);
    this.originalToken = originalToken;
  }
}
