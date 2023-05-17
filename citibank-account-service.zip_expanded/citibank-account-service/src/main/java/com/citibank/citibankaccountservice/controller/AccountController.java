package com.citibank.citibankaccountservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Value("${server.port}")
	private String port;
	
	@GetMapping("/balance")
	public ResponseEntity<Object> fetchBalance() {
		Map<String, Object> map = new HashMap<>();
		map.put("port", port);
		map.put("balance", Double.valueOf(Math.random() * 10000).intValue());
		return ResponseEntity.status(200).body(map);
	}
}
