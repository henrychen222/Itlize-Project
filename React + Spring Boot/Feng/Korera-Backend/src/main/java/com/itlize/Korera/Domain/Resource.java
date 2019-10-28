package com.itlize.Korera.Domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Resource")
public class Resource {
	
	private int id;
	private String name;
	private String code;
	private int projectId;
	
//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "Resource")
//    private Set<AttributeValue> attributes = new HashSet<>();


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "ResourceName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "ResourceCode")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "ProjectId")
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
//	public Set<AttributeValue> getAttributes() {
//		return attributes;
//	}
//	public void setComments(Set<AttributeValue> attributes) {
//		this.attributes = attributes;
//	}
	
}
