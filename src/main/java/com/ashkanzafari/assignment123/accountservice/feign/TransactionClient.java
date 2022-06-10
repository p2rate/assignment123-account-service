package com.ashkanzafari.assignment123.accountservice.feign;


import com.ashkanzafari.assignment123.accountservice.dto.response.ApiResponse;
import com.ashkanzafari.assignment123.accountservice.feign.model.request.DepositRequestDto;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.Balance;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.DepositResponseDto;
import com.ashkanzafari.assignment123.accountservice.feign.model.response.User;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TransactionClient.
 *
 * <p>Feign client for communicating with Transaction-service</p>
 */
@FeignClient(
        value = "TransactionClient",
        url = "${services.transaction.base-url}"
)
public interface TransactionClient {

  /**
   * Method that is used to deposit credit to an account
   *
   * @return List of Destinations
   */
  @RequestMapping(
          method = RequestMethod.POST,
          value = "/api/operator/v1/transaction/deposit",
          consumes = "application/json"
  )
  @Headers("Content-Type: application/json")
  ApiResponse<DepositResponseDto> deposit(final @RequestBody DepositRequestDto depositRequestDto);


  /**
   * Method to get account info from transaction-service
   *
   * @param accountId
   * @return
   */
  @RequestMapping(
          method = RequestMethod.GET,
          value = "/api/v1/transaction/balance/{accountId}"
  )
  ApiResponse<Balance> getAccountInfo(@PathVariable final String accountId);
}
