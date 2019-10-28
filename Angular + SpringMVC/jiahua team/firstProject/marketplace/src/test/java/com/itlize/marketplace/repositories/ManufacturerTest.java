package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.Manufacturer;
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
public class ManufacturerTest {

  @Resource
  private ManufacturerRepository manufacturerRepository;

  @Test
  public void givenManufacturer_whenSave_thenGetOK() {
    String name = "Big Ass";
    String department = "Technical Support";
    long phone = 8004668200l;
    String email = "techsupport@bigass.com";
    String web = "http://www.bigassfans.com";

    Manufacturer manufacturer = new Manufacturer();
    manufacturer.setName(name);
    manufacturer.setDepartment(department);
    manufacturer.setPhone(phone);
    manufacturer.setEmail(email);
    manufacturer.setWeb(web);

    Manufacturer savedManufacturer = manufacturerRepository.save(manufacturer);
    assertEquals(manufacturer, savedManufacturer);

  }

}
