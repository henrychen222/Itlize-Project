package com.itlize.Korera.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itlize.Korera.Domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
