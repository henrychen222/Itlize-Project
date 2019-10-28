package com.joole.service;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.joole.domain.SubCategory;
import com.joole.xml.Parameter;
import com.joole.xml.Parameters;



public abstract class ExtractSubCategoryAttribute {
	
	
	@SuppressWarnings("unchecked")
	public List<Parameter> extractSubAttribute(SubCategory subCategory) {
		
		List<Parameter> parameters = null;
		try {
			JAXBContext cxt = JAXBContext.newInstance(Parameters.class);
			Unmarshaller unmarshaller = cxt.createUnmarshaller();

			
			parameters = (List<Parameter>) unmarshaller
					.unmarshal(new StreamSource(new StringReader(subCategory.getParameters())));


		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return parameters;
	}
	


}
