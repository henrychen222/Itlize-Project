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
public class AddressTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public void address_save_fouond() {
    String addrLine1 = "242 Old New Brunswick Rd #250, Piscataway Township, NJ 08854";
    String addrLine2 = "#250";
    String city = "Piscataway Township";
    int zip = 8854;
    String state = "NJ";
    String country = "USA";

    Address address = new Address();
    address.setAddrLine1(addrLine1);
    address.setAddrLine2(addrLine2);
    address.setCity(city);
    address.setZip(zip);
    address.setState(state);
    address.setCountry(country);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(address);

    Address foundAddress = session.find(Address.class, id);
    assertEquals(address, foundAddress);
  }
}
