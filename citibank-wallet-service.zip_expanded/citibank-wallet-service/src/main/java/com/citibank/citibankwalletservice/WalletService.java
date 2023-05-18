package com.citibank.citibankwalletservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service // this will be registered as an object in spring container (rest template will be there)
public class WalletService {

	@Autowired // this injects RestTemplate present in the spring container 
	private RestTemplate rest;
	
	@Autowired
	private AccountClient accountClient;
	
	// a method that calls remote service http://AMS/account/balance
	// Here we need configure with the @CircuitBreaker to set up the circuit breaker properties
	@CircuitBreaker(name = "walletInstance", fallbackMethod = "fallback")
	public Wallet initializeWallet() {
		//String remoteURL = "http://AMS/account/balance";
		// wallet has 4 properties - walletNumber, port, balance, description
		// in that port & balance will be initialized because JSON has { port, balance }
		//Wallet wallet = rest.getForObject(remoteURL, Wallet.class); // Get : http://AMS/account/balance
		System.out.println("******* Call is going to the Remote Microservice *******");
		Wallet wallet = accountClient.fetchAccountBalance(); // Get : http://AMS/account/balance
		wallet.setWalletNumber(Double.valueOf(wallet.getBalance() * 31).intValue());
		wallet.setDescription("AccountMicroservice running in "+wallet.getPort()+" coming from remote microservice");
		return wallet;
	}
	public Wallet fallback(Throwable t) {
		System.out.println("**** Call is handled by fallback ****");
		System.out.println("Exception is: "+t.getMessage());
		Wallet wallet = new Wallet();
		wallet.setDescription("Wallet is give you alternate response");
		return wallet;
	}
}
