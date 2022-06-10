package com.ashkanzafari.assignment123.accountservice.dto.response;

import com.ashkanzafari.assignment123.accountservice.feign.model.response.Balance;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InfoDto {

  private User user;
  private List<Balance> accounts;
}
