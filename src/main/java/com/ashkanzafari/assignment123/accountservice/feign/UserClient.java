package com.ashkanzafari.assignment123.accountservice.feign;


import com.ashkanzafari.assignment123.accountservice.dto.response.AccountDto;
import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AccountClient.
 *
 * <p>Feign client for communicating with account-service</p>
 */
@FeignClient(
    value = "UserClient",
    url = "${services.user.base-url}"
)
public interface UserClient {

    /**
     * Method that is used to ensure a user is valid
     *
     * @return  List of Destinations
     */
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/api/admin/v1/user/id/{userId}",
        consumes = "application/json"
    )
    @Headers("Content-Type: application/json")
    ApiResponse<User> getUser(final @PathVariable String userId);

  @RequestMapping(
          method = RequestMethod.GET,
          value = "/api/v1/user",
          consumes = "application/json"
  )
  @Headers("Content-Type: application/json")
  ApiResponse<User> getUserInfo();
}
