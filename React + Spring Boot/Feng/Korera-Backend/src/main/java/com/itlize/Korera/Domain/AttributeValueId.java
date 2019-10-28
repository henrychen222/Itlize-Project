package com.itlize.Korera.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


public class AttributeValueId implements Serializable {
//	@Column(name = "resourceId")
	private int resourceId;
	
//	@ManyToOne
//	@JoinColumn(name = "AttributeId")
//	private Attribute attribute;
//	@Column(name = "attributeId")
	private String attributeName;
//	
//	public int getResourceId() {
//		return resourceId;
//	}
//
//	public void setResourceId(int resourceId) {
//		this.resourceId = resourceId;
//	}

//	public Attribute getAttribute() {
//		return attribute;
//	}
//
//	public void setAttribute(Attribute attribute) {
//		this.attribute = attribute;
//	}
////
//	public int getAttributeId() {
//		return attributeId;
//	}
//
//	public void setAttributeId(int attributeId) {
//		this.attributeId = attributeId;
//	}
}
