package com.itlize.Korera.Service;

import java.util.List;

import com.itlize.Korera.Domain.Attribute;
import com.itlize.Korera.Domain.Project;
import com.itlize.Korera.Domain.QuantityServey;
import com.itlize.Korera.Domain.Resource;

public interface ResourceService {
	public List<Resource> getResourceByProject(int projectId);
	public void saveResources(List<Resource> toSave);
	
	public List<List<Object>> getResourceWithAttri(int projectId);
	public List<Project> getAllProjects();
	public List<Attribute> getAttributesByProject(int projectId);
	public void saveAttributes(List<Attribute> attributes, int projectId);
	public List<QuantityServey> getQuantityByProject(int projectId);
	public void saveQuantities(List<QuantityServey> quantities, int projectId);
}
