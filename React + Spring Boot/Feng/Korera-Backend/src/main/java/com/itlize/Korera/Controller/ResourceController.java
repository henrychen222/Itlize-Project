package com.itlize.Korera.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itlize.Korera.DAO.AttributeValueRepository;
import com.itlize.Korera.Domain.Attribute;
import com.itlize.Korera.Domain.AttributeValue;
import com.itlize.Korera.Domain.Project;
import com.itlize.Korera.Domain.QuantityServey;
import com.itlize.Korera.Domain.Resource;
import com.itlize.Korera.Service.ResourceService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class ResourceController {
	
	@Autowired
	AttributeValueRepository attributeValueRepository;
	@Autowired
	private ResourceService resourceSerivce;
	final ObjectMapper mapper = new ObjectMapper();
	
	@GetMapping("/{projectId}/resources")
	public List<List<Object>> getAllResources(@PathVariable("projectId")int id) {
		return resourceSerivce.getResourceWithAttri(id);
	}
	
	@PostMapping("/resources")
	public void saveResources(@RequestBody List<Resource> toSave) {
		resourceSerivce.saveResources(toSave);
	}
	
	@PostMapping("/attributes")
	public void saveAttributeValues(@RequestBody List<AttributeValue> body) {
//		for(int i = 0; i < body.size(); i++) {
//			Resource r = (Resource)body.get(i).get(0);
//			System.out.println(r);
//		}

//		Resource r = mapper.convertValue(body.get(0).get(0), Resource.class);
//		List<AttributeValue> a = mapper.convertValue(body.get(0).get(1), ArrayList.class);
//		List<AttributeValue> toSave = new ArrayList<>();
//		for(int i = 0; i < body.size(); i++) {
//			Map o = (Map)body.get(i);
//			AttributeValue attr = mapper.convertValue(o, AttributeValue.class);
//			System.out.println(o.get("attributeId"));
//			attr.setAttributeId((int)o.get("attributeId"));
//			
//			toSave.add(attr);
//	
//		}
		attributeValueRepository.saveAll(body);
//		return body.get(0);
		
	}
	
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return resourceSerivce.getAllProjects();
	}
	
	@GetMapping("/{projectId}/attributes")
	public List<Attribute> getAttributes(@PathVariable("projectId")int id) {
		return resourceSerivce.getAttributesByProject(id);
	}
	
	@PostMapping("/{projectId}/attributes") 
	public void saveAttributes(@PathVariable("projectId") int projectId, 
			@RequestBody List<Attribute> attributes) {
		resourceSerivce.saveAttributes(attributes, projectId);
	}
	
	@GetMapping("/{projectId}/quantities")
	public List<QuantityServey> getQuantities(@PathVariable("projectId")int id) {
		return resourceSerivce.getQuantityByProject(id);
	}
	
	@PostMapping("/{projectId}/quantities")
	public void saveQuantities(@PathVariable("projectId") int projectId, 
			@RequestBody List<QuantityServey> quantities) {
		resourceSerivce.saveQuantities(quantities, projectId);
	}

}
