package com.itlize.Korera.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.Korera.Domain.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Integer>{
	List<Resource> findByProjectId(int projectId);
	
}
