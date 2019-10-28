package com.itlize.Korera.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.Korera.Domain.QuantityServey;

public interface QuantityRepository extends JpaRepository<QuantityServey, Integer>{
	public List<QuantityServey> findByProjectId(int projectId);
}
