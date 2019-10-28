package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EntitiesJpaConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class ProjectTest {

  @Resource
  private ProjectRepository projectRepository;

  @Test
  public void givenProject_whenSave_thenGetOK() {
    String name = "The project";
    String address = "somewhere in usa";
    String type = "some building type";
    String size = "large";
    String clientName = "Random guy";
    String productsList = "[product1, product2, product3...]";
    double quote = 76543.21;

    Project project = new Project();
    project.setAddress(address);
    project.setClientName(clientName);
    project.setName(name);
    project.setProductsList(productsList);
    project.setQuote(quote);
    project.setSize(size);
    project.setType(type);

    Project savedProject = projectRepository.save(project);
    assertEquals(project, savedProject);
  }

}
