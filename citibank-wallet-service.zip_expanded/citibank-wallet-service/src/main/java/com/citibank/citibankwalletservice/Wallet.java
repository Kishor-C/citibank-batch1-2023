package com.citibank.citibankwalletservice;

// Wallet class represents the wallet number, balance, port & description
// Since JSON has balance & port property we need to have the same properties
public class Wallet {
	private int walletNumber;
	private double balance;
	private int port;
	private String description;
	// generate setters & getters
	public int getWalletNumber() {
		return walletNumber;
	}
	public void setWalletNumber(int walletNumber) {
		this.walletNumber = walletNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
