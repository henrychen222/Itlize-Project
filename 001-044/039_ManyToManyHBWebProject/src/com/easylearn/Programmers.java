package com.easylearn;
// Generated May 5, 2016 6:27:00 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Programmers generated by hbm2java
 */
@Entity
@Table(name = "3_PROGRAMMERS", catalog = "java_weekend_batch1")
public class Programmers implements java.io.Serializable {

	private int pid;
	private String pname;
	private Integer salary;
	private Set<Projects> projectses = new HashSet<Projects>(0);

	public Programmers() {
	}

	public Programmers(int pid) {
		this.pid = pid;
	}

	public Programmers(int pid, String pname, Integer salary) {
		this.pid = pid;
		this.pname = pname;
		this.salary = salary;
	}

	@Id

	@Column(name = "pid", unique = true, nullable = false)
	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name = "pname", length = 40)
	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(name = "salary")
	public Integer getSalary() {
		return this.salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name = "3_PROGRAMMERS_PROJECTS", catalog = "java_weekend_batch1", 
		joinColumns = {
				@JoinColumn(name = "programmer_id", nullable = false, updatable = false) }, 
		inverseJoinColumns = {
				@JoinColumn(name = "project_id", nullable = false, updatable = false) }
			)
	public Set<Projects> getProjectses() {
		return this.projectses;
	}

	public void setProjectses(Set<Projects> projectses) {
		this.projectses = projectses;
	}

}
