package com.itlize.Korera.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "AttributeValue")
@IdClass(AttributeValueId.class)
//@SecondaryTable(name = "Attribute", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))

public class AttributeValue implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "Value")
	private String value;
	
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ResourceId", nullable = false)
//	private Resource resource;
//	@Column(name = "ResourceId")
//	private int resourceId;
//	
////	@ManyToOne
////	@JoinColumn(name = "AttributeId")
////	private Attribute attribute;
//	@Column(name = "AttributeId")
//	private int attributeId ;
	@Id
	private int resourceId;
	
	@Id 
	private String attributeName;
	
//	@Column(name = "AttributeName", table = "Attribute")
//	private String attributeName;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
//
//	public AttributeValueId getKeys() {
//		return keys;
//	}
//
//	public void setKeys(AttributeValueId keys) {
//		this.keys = keys;
//	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}



}

//	public String getAttributeName() {
//		return attributeName;
//	}
//
//	public void setAttributeName(String attributeName) {
//		this.attributeName = attributeName;
//	}
