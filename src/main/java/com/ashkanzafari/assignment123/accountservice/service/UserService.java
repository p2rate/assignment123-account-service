package com.ashkanzafari.assignment123.accountservice.service;

import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.exception.UserNotExistsException;
import com.ashkanzafari.assignment123.accountservice.feign.UserClient;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserClient userClient;

  public void validateUser(String userId) throws UserNotExistsException {

    ApiResponse<User> user = userClient.getUser(userId);
    if (user.getPayload() == null) {
      throw new UserNotExistsException();
    }

  }

  public User getAuthenticatedUserInfo() {

    ApiResponse<User> userInfo = userClient.getUserInfo();
    if (userInfo.getPayload() == null)
      throw new UserNotExistsException();

    return userInfo.getPayload();
  }
}
