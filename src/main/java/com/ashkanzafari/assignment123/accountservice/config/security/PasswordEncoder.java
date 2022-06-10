package com.ashkanzafari.assignment123.accountservice.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordEncoder {

  @Bean
  public org.springframework.security.crypto.password.PasswordEncoder encoder() {

    return new BCryptPasswordEncoder();
  }
}
