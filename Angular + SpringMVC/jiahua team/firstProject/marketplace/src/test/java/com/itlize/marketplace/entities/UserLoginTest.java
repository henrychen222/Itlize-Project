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
public class UserLoginTest {

  @Autowired
  private SessionFactory sessionFactory;


  @Test
  public void address_save_fouond() {
    String email = "jiahua.zhang@itlize.com";
    String username = "Jiahua";
    String password = "pass";

    UserLogin userLogin = new UserLogin();
    userLogin.setEmail(email);
    userLogin.setUsername(username);
    userLogin.setPassword(password);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(userLogin);

    UserLogin foundUserLogin = session.find(UserLogin.class, id);
    assertEquals(userLogin, foundUserLogin);
  }
}
