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
public class UserInfoTest {
  @Autowired
  private SessionFactory sessionFactory;

  private static String firstName = "Jiahua";
  private static String lastName = "Zhang";
  private static String picturePath =
      "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Colorful_spring_garden.jpg/1200px-Colorful_spring_garden.jpg";
  private static UserLogin userLogin = null;
  private static Address address = null;
  private static UserInfo userInfo = new UserInfo();

  @Test
  public void new_UserInfo_with_null_userLogin_and_Addres() {
    userInfo.setFirstName(firstName);
    userInfo.setLastName(lastName);
    userInfo.setPicturePath(picturePath);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(userInfo);

    UserInfo foundUserInfo = session.find(UserInfo.class, id);
    assertEquals(userInfo, foundUserInfo);
  }

  private String email = "itlize@work.com";
  private String username = "Jiahua";
  private String password = "password";

  private static String addrLine1 = "242 Old New Brunswick Rd #250, Piscataway Township, NJ 08854";
  private static String addrLine2 = "#250";
  private static String city = "Piscataway Township";
  private static int zip = 8854;
  private static String state = "NJ";
  private static String country = "USA";

  @Test
  public void new_UserInfo_with_userLogin_and_Addres() {
    address = new Address();
    address.setAddrLine1(addrLine1);
    address.setAddrLine2(addrLine2);
    address.setCity(city);
    address.setCountry(country);
    address.setState(state);
    address.setZip(zip);

    userLogin = new UserLogin();
    userLogin.setEmail(email);
    userLogin.setPassword(password);
    userLogin.setUsername(username);

    userInfo.setFirstName(firstName);
    userInfo.setLastName(lastName);
    userInfo.setPicturePath(picturePath);
    userInfo.setAddress(address);
    userInfo.setUserLogin(userLogin);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(userInfo);

    UserInfo foundUserInfo = session.find(UserInfo.class, id);
    assertEquals(userInfo, foundUserInfo);
  }

}
