package com.itlize.marketplace.entities;

import static org.junit.Assert.assertEquals;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProjectTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public void project_save_fouond() {
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

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(project);

    Project foundProject = session.find(Project.class, id);
    assertEquals(project, foundProject);
  }
}
