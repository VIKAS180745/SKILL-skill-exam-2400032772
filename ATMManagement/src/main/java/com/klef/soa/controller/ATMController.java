package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.klef.soa.entity.ATM;
import com.klef.soa.service.ATMService;
@RestController
@RequestMapping("/atm")
public class ATMController {
	@Autowired
	private ATMService service;

	@GetMapping("/")
	public String demo() {
		return "Spring Boot Project";
	}
	// Add ATM
	@PostMapping("/add")
	public ResponseEntity<ATM> addATM(@RequestBody ATM atm) {
		ATM a = service.addATM(atm);
		return ResponseEntity.status(201).body(a);
	}
	@GetMapping("/displayall")
	public ResponseEntity<List<ATM>> displayAllATMs() {
		List<ATM> atms = service.displayAllATMs();
		return ResponseEntity.status(201).body(atms);
	}
	@GetMapping("/display")
	public ResponseEntity<?> displayATMById(@RequestParam Long id) {
		ATM atm = service.displayATMById(id);

		if (atm != null) {
			return ResponseEntity.status(200).body(atm);
		} else {
			return ResponseEntity.status(404).body("ATM ID Not Found");
		}
	}

	// Update ATM
	@PutMapping("/update")
	public ResponseEntity<?> updateATM(@RequestBody ATM atm) {
		ATM a = service.updateATM(atm);

		if (a != null) {
			return ResponseEntity.ok(a);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ATM ID Not Found");
		}
	}

	// Delete ATM By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteATMById(@PathVariable Long id) {
		String message = service.deleteATMById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<ATM>> displayATMByName(@PathVariable String name) {
		List<ATM> atms = service.displayATMByName(name);
		return ResponseEntity.status(200).body(atms);
	}

	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<ATM>> displayATMByType(@PathVariable String type) {
		List<ATM> atms = service.displayATMByType(type);
		return ResponseEntity.status(200).body(atms);
	}

	@GetMapping("/count")
	public ResponseEntity<String> atmCount() {
		Long count = service.atmCount();
		String msg = "Total ATMs = " + count;
		return ResponseEntity.ok(msg);
	}

}