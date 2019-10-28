package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.Product;
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
public class ProductTest {

  @Resource
  private ProductRepository productRepository;

  @Test
  public void givenProduct_whenSave_thenGetOK() {
    String series = "Haiku H";
    String model = "S3150-S0-BC-04-01-C-01";
    String useType = "Commercial";
    String application = "Indoor";
    String mountingLocation = "Roof";
    String accessories = "With light";
    int modelYear = 2016;
    String category = "mechanical";
    String subCategory = "HVAC fans";
    String picturePath =
        "https://www.picclickimg.com/d/l400/pict/263931728108_/L-Series-52-In-Integrated-LED-Indoor-Ceiling.jpg";
    Map<String, String> data = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("airflow", "5467");
        put("power-min", "1.95");
        put("power-max", "21.14");
      }
    };
    Map<String, Integer> dataInt = new HashMap<String, Integer>() {
      private static final long serialVersionUID = 1855301064415267547L;
      {
        put("number of fan speeds", 7);
        put("sound at max speed", 35);
      }
    };

    Map<String, Double> dataDouble = new HashMap<String, Double>() {
      private static final long serialVersionUID = 1L;
      {
        put("height-min", 12.3);
        put("height-max", 57.0);
      }
    };

    Date verified = new Date();
    String details =
        "Airfoils – Moso bamboo – 60” diameter Airfoil Finishes – Caramel Bamboo or Cocoa Bamboo Hardware Finishes – Satin Nickel, Oil-Rubbed Bronze, Black or White";

    Product product = new Product();
    product.setAccessories(accessories);
    product.setApplication(application);
    product.setCategory(category);
    product.setData(data);
    product.setDataInt(dataInt);
    product.setDataDouble(dataDouble);
    product.setModel(model);
    product.setModelYear(modelYear);
    product.setMountingLocation(mountingLocation);
    product.setPicturePath(picturePath);
    product.setSeries(series);
    product.setSubCategory(subCategory);
    product.setUseType(useType);
    product.setVerified(verified);
    product.setDetails(details);

    Product savedProduct = productRepository.save(product);
    assertEquals(product, savedProduct);
  }

}
