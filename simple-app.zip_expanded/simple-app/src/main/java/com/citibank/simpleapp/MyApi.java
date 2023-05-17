package com.citibank.simpleapp;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MyApi {
	// http://localhost:port/v1/welcome
	@GetMapping(path = "/welcome")
	public ResponseEntity<Object> greet() {
		Map<String, Object> map = new HashMap<>();
		map.put("name", "Alex");
		map.put("dob", LocalDate.of(1999, 10, 25));
		map.put("phone", 999209393);
		return ResponseEntity.status(200).body(map);
	}
	@PostMapping(path = "/store", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody Employee emp) {
		return ResponseEntity.status(200).body("Employee created "+emp.getId());
	}
}
