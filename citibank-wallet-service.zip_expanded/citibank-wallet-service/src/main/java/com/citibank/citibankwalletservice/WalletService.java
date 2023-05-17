package com.citibank.citibankwalletservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service // this will be registered as an object in spring container (rest template will be there)
public class WalletService {

	@Autowired // this injects RestTemplate present in the spring container 
	private RestTemplate rest;
	
	// a method that calls remote service http://AMS/account/balance
	
	public Wallet initializeWallet() {
		String remoteURL = "http://AMS/account/balance";
		// wallet has 4 properties - walletNumber, port, balance, description
		// in that port & balance will be initialized because JSON has { port, balance }
		Wallet wallet = rest.getForObject(remoteURL, Wallet.class); // Get : http://AMS/account/balance
		wallet.setWalletNumber(Double.valueOf(wallet.getBalance() * 31).intValue());
		wallet.setDescription("AccountMicroservice running in "+wallet.getPort());
		return wallet;
	}
}
