package com.dev.db;

import java.util.Date;

/**
 * Employee entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Employee implements java.io.Serializable {

	// Fields

	private Integer idEmp;
	private String nmLast;
	private String nmFirst;
	private String nmMid;
	private Date dtDob;
	private String txAddress;
	private Integer idPhone;
	private String idUser;
	private Date tmStamp;
	private int totalrecords;
	private int current_page;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Integer idEmp) {
		this.idEmp = idEmp;
	}

	/** full constructor */
	public Employee(Integer idEmp, String nmLast, String nmFirst, String nmMid, Date dtDob, String txAddress, Integer idPhone, String idUser, Date tmStamp) {
		this.idEmp = idEmp;
		this.nmLast = nmLast;
		this.nmFirst = nmFirst;
		this.nmMid = nmMid;
		this.dtDob = dtDob;
		this.txAddress = txAddress;
		this.idPhone = idPhone;
		this.idUser = idUser;
		this.tmStamp = tmStamp;
	}

	// Property accessors

	public Integer getIdEmp() {
		return this.idEmp;
	}

	public void setIdEmp(Integer idEmp) {
		this.idEmp = idEmp;
	}

	public String getNmLast() {
		return this.nmLast;
	}

	public void setNmLast(String nmLast) {
		this.nmLast = nmLast;
	}

	public String getNmFirst() {
		return this.nmFirst;
	}

	public void setNmFirst(String nmFirst) {
		this.nmFirst = nmFirst;
	}

	public String getNmMid() {
		return this.nmMid;
	}

	public void setNmMid(String nmMid) {
		this.nmMid = nmMid;
	}

	public Date getDtDob() {
		return this.dtDob;
	}

	public void setDtDob(Date dtDob) {
		this.dtDob = dtDob;
	}

	public String getTxAddress() {
		return this.txAddress;
	}

	public void setTxAddress(String txAddress) {
		this.txAddress = txAddress;
	}

	public Integer getIdPhone() {
		return this.idPhone;
	}

	public void setIdPhone(Integer idPhone) {
		this.idPhone = idPhone;
	}

	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public Date getTmStamp() {
		return this.tmStamp;
	}

	public void setTmStamp(Date tmStamp) {
		this.tmStamp = tmStamp;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public int getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(int current_page) {
		this.current_page = current_page;
	}

}