package com.joole.xml;


public class Parameter {
	
	private String name;
	private String type;
	private String unit;
	
	public Parameter() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public String toString() {
		return "Parameter [name=" + name + ", type=" + type + ", unit=" + unit + "]";
	}
	

}
