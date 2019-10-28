package com.joole.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name = "SubCategories")
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCategoryId;
	@Column
	private String categoryName;

	@Column
	private String subCategoryName;

	@Column
	private String parameters;

	@ManyToOne
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;

	public SubCategory() {

	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "SubCategoty [subCategoryId=" + subCategoryId + ", categoryName=" + categoryName + ", subCategoryName="
				+ subCategoryName + ", parameters=" + parameters + "]";
	}

}
