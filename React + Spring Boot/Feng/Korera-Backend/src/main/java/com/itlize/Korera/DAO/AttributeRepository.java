package com.itlize.Korera.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.Korera.Domain.Attribute;

public interface AttributeRepository extends JpaRepository<Attribute, Integer>{
	public List<Attribute> findByProjectId(int projectId);
}
