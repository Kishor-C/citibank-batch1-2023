package com.citibank.citibankwalletservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("http://AMS/")
public interface AccountClient {

	// Get: /account/balance
	@GetMapping("/account/balance") // http://AMS/account/balance
	public Wallet fetchAccountBalance();
	
}
