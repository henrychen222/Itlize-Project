package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.Address;
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
public class AddressTest {

  @Resource
  private AddressRepository addressRepository;

  @Test
  public void givenAddress_whenSave_thenGetOk() {
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

    Address savedAddress = addressRepository.save(address);
    assertEquals(address, savedAddress);

  }

}
