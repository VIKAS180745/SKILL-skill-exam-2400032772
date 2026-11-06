package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.ATM;
import java.util.List;

@Repository
public interface ATMRepository extends JpaRepository<ATM, Long>
{
	// from ATM a where a.name=?1
	List<ATM> findByName(String name);

	// from ATM a where a.type=?1
	List<ATM> findByType(String type);
}