package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.SalesRepresentative;
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
public class SalesRepresentativeTest {

  @Resource
  private SalesRepresentativeRepository salesRepresentativeRepository;

  @Test
  public void givensalesRepresentative_whenSave_thenGetOk() {
    String name = "Marty McFly";
    long phone = 6508896222l;
    String email = "marty@mcfly.com";
    String web = "http://www.test.com";

    SalesRepresentative salesRepresentative = new SalesRepresentative();
    salesRepresentative.setEmail(email);
    salesRepresentative.setName(name);
    salesRepresentative.setPhone(phone);
    salesRepresentative.setWeb(web);

    SalesRepresentative savedSalesRepresentative =
        salesRepresentativeRepository.save(salesRepresentative);
    assertEquals(salesRepresentative, savedSalesRepresentative);

  }

}
