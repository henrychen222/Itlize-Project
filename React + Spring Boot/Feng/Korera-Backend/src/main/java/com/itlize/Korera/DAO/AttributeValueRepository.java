package com.itlize.Korera.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.Korera.Domain.AttributeValue;
import com.itlize.Korera.Domain.AttributeValueId;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, AttributeValueId>{

	public List<AttributeValue> findByResourceId(int resourceId);
	
	
}
