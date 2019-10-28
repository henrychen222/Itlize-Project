package com.joole.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parameters")
public class Parameters extends ArrayList<Parameter> {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "parameter")
	public List<Parameter> getParameters() {
		return this;
	}

}