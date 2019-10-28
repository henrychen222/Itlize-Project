package com.itlize.marketplace.entities;

import static org.junit.Assert.assertNotNull;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class HibernateTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Autowired
  private HibernateTransactionManager transactionManager;

  @Test
  public void autowired_no_error() {
    assertNotNull(sessionFactory);
    assertNotNull(transactionManager);
  }

}
