package com.itlize.Korera.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itlize.Korera.DAO.AttributeRepository;
import com.itlize.Korera.DAO.AttributeValueRepository;
import com.itlize.Korera.DAO.ProjectRepository;
import com.itlize.Korera.DAO.QuantityRepository;
import com.itlize.Korera.DAO.ResourceRepository;
import com.itlize.Korera.Domain.Attribute;
import com.itlize.Korera.Domain.AttributeValue;
import com.itlize.Korera.Domain.Project;
import com.itlize.Korera.Domain.QuantityServey;
import com.itlize.Korera.Domain.Resource;
import com.itlize.Korera.Service.ResourceService;

@Service
@Transactional

public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceRepository resourceRespository;
	
	@Autowired
	private AttributeValueRepository attrValueRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	@Autowired
	private QuantityRepository quantityRepository;

	@Override
	public List<Resource> getResourceByProject(int projectId) {
		// TODO Auto-generated method stub
		return resourceRespository.findByProjectId(projectId);
	}

	@Override
	public void saveResources(List<Resource> toSave) {
		// TODO Auto-generated method stub
		resourceRespository.saveAll(toSave);
	}

	@Override
	public List<List<Object>> getResourceWithAttri(int projectId) {
		// TODO Auto-generated method stub
		List<Resource> resources = this.getResourceByProject(projectId);
		List<List<Object>> res = new ArrayList<>();
		for(int i = 0; i < resources.size(); i++) {
			Resource r = resources.get(i);
//			AttributeValueId key = new AttributeValueId();
			List<AttributeValue> attris = this.attrValueRepository.findByResourceId(r.getId());
			List<Object> resourceCompleted = new ArrayList<>();
			
			resourceCompleted.add(r);
			resourceCompleted.add(attris);
			res.add(resourceCompleted);
		}
		return res;
	}

	@Override
	public List<Project> getAllProjects() {
		// TODO Auto-generated method stub
		
		return projectRepository.findAll();
	}

	@Override
	public List<Attribute> getAttributesByProject(int projectId) {
		// TODO Auto-generated method stub
		return attributeRepository.findByProjectId(projectId);
	}

	@Override
	public List<QuantityServey> getQuantityByProject(int projectId) {
		// TODO Auto-generated method stub
		return quantityRepository.findByProjectId(projectId);
	}

	@Override
	public void saveAttributes(List<Attribute> attributes, int projectId) {
		// TODO Auto-generated method stub
		for(int i = 0; i < attributes.size(); i++) {
			attributes.get(i).setProjectId(projectId);
		}
		attributeRepository.saveAll(attributes);
	}

	@Override
	public void saveQuantities(List<QuantityServey> quantities, int projectId) {
		// TODO Auto-generated method stub
		for(int i = 0; i < quantities.size(); i++) {
			quantities.get(i).setProjectId(projectId);
		}
		quantityRepository.saveAll(quantities);
	}

}
