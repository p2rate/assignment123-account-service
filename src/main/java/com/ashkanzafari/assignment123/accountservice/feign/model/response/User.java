package com.ashkanzafari.assignment123.accountservice.feign.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * User.
 *
 * <p>Class to retrieve User info from user-service</p>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

  private String username;

  private String firstName;

  private String lastName;

  private String email;

}
