package com.citibank.citibankwalletservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this will register controller in the spring container
@RequestMapping("/wallet")
public class WalletController {

	// // WalletController is registered in spring container hence WalletService will be initialized
	@Autowired
	private WalletService service; 
	
	@GetMapping("/amount")
	public ResponseEntity<Object> fetchWallet() {
		Wallet wallet = service.initializeWallet();
		return ResponseEntity.status(200).body(wallet);
	}
}
