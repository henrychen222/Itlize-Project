package com.itlize.Korera.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attribute")
public class Attribute {

	@Id
	@Column(name = "AttributeName")
	private String name;
	
	@Column(name = "Flag")
	private int flag;
	
//	@ManyToOne
//	@JoinColumn(name = "ProjectId")
//	private Project project;
	@Column(name = "ProjectId")
	private int projectId;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
//
//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
