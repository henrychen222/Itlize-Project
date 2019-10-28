package com.joole.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column
	private int userId;
	@Column
	private String productName;
	@Column
	private Date verifiedDate;
	@Column
	private byte[] productImage;
	
	@Column
	private int subCategoryId;
	
	@Column
	private String summary;
	@Column
	private String productDetails;
	@Column
	private String productContact;
	
	@ManyToOne
	@JoinColumn(name="subCategoryId", insertable=false, updatable=false)
	private SubCategory subCategory;
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}


	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getVerifiedDate() {
		return verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

	public byte[] getProductImage() {
		return productImage;
	}

	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}



	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public String getProductContact() {
		return productContact;
	}

	public void setProductContact(String productContact) {
		this.productContact = productContact;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", userId=" + userId + ", productName=" + productName
				+ ", verifiedDate=" + verifiedDate + ", productImage=" + Arrays.toString(productImage)
				+ ", subCategoryId=" + subCategoryId + ", summary=" + summary + ", productDetails=" + productDetails
				+ ", productContact=" + productContact + "]";
	}

	
	
	
	
	

}
