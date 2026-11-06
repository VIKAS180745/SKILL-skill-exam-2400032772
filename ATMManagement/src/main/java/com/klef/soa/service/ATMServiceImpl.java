package com.klef.soa.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klef.soa.entity.ATM;
import com.klef.soa.repository.ATMRepository;

@Service
public class ATMServiceImpl implements ATMService
{
	@Autowired
	private ATMRepository repo;
	@Override
	public ATM addATM(ATM atm)
	{
		return repo.save(atm);
	}
	@Override
	public ATM updateATM(ATM atm)
	{
		Optional<ATM> optional = repo.findById(atm.getAtmId());

		if(optional.isPresent())
		{
			ATM a = optional.get();
			a.setName(atm.getName());
			a.setType(atm.getType());
			a.setStatus(atm.getStatus());
			a.setLocation(atm.getLocation());
			return repo.save(a);
		}
		else
		{
			return null;
		}
	}
	@Override
	public List<ATM> displayAllATMs()
	{
		return repo.findAll();
	}
	@Override
	public ATM displayATMById(Long atmId)
	{
		return repo.findById(atmId).orElse(null);
	}
	@Override
	public String deleteATMById(Long atmId)
	{
		boolean flag = repo.existsById(atmId);
		if(flag)
		{
			repo.deleteById(atmId);
			return "ATM Deleted Successfully";
		}
		else
		{
			return "ATM ID Not Found";
		}
	}
	@Override
	public List<ATM> displayATMByName(String name)
	{
		return repo.findByName(name);
	}

	@Override
	public List<ATM> displayATMByType(String type)
	{
		return repo.findByType(type);
	}
	@Override
	public Long atmCount()
	{
		return repo.count();
	}
}