package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.ATM;

public interface ATMService
{
	ATM addATM(ATM atm);
	ATM updateATM(ATM atm);
	List<ATM> displayAllATMs();
	ATM displayATMById(Long atmId);
	String deleteATMById(Long atmId);
	List<ATM> displayATMByName(String name);
	List<ATM> displayATMByType(String type);
	Long atmCount();

}