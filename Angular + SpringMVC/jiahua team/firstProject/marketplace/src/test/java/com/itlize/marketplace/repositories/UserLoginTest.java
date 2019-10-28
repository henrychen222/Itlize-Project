package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.UserLogin;
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
public class UserLoginTest {

  @Resource
  private UserLoginRepository userLoginRepository;

  @Test
  public void givenUserLogin_whenSave_thenGetOk() {
    String email = "jiahua.zhang@itlize.com";
    String username = "Jiahua";
    String password = "pass";

    UserLogin userLogin = new UserLogin();
    userLogin.setEmail(email);
    userLogin.setUsername(username);
    userLogin.setPassword(password);

    UserLogin savedUserLogin = userLoginRepository.save(userLogin);
    assertEquals(userLogin, savedUserLogin);
  }

}
