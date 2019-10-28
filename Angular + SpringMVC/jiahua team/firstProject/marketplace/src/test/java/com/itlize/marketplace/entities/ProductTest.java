package com.itlize.marketplace.entities;

import static org.junit.Assert.assertEquals;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
public class ProductTest {

  @Autowired
  private SessionFactory sessionFactory;

  private static String series = "Haiku H";
  private static String model = "S3150-S0-BC-04-01-C-01";
  private static String useType = "Commercial";
  private static String application = "Indoor";
  private static String mountingLocation = "Roof";
  private static String accessories = "With light";
  private static int modelYear = 2016;
  private static String category = "mechanical";
  private static String subCategory = "HVAC fans";
  private static String picturePath =
      "https://www.picclickimg.com/d/l400/pict/263931728108_/L-Series-52-In-Integrated-LED-Indoor-Ceiling.jpg";
  private static Map<String, String> data = new HashMap<String, String>() {
    private static final long serialVersionUID = 1L;
    {
      put("airflow", "5467");
      put("power-min", "1.95");
      put("power-max", "21.14");
    }
  };

  private static Date verified = new Date();
  private static String details =
      "Airfoils – Moso bamboo – 60” diameter Airfoil Finishes – Caramel Bamboo or Cocoa Bamboo Hardware Finishes – Satin Nickel, Oil-Rubbed Bronze, Black or White";

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

  private static Manufacturer manufacturer = null;
  private static SalesRepresentative salesRepresentative = null;
  private static Product product = new Product();

  @Test
  public void productwith_null_manufacturer_salesRepresentative() {
    product.setAccessories(accessories);
    product.setApplication(application);
    product.setCategory(category);
    product.setManufacturer(manufacturer);
    product.setModel(model);
    product.setModelYear(modelYear);
    product.setMountingLocation(mountingLocation);
    product.setPicturePath(picturePath);
    product.setSeries(series);
    product.setSubCategory(subCategory);
    product.setUseType(useType);
    product.setData(data);
    product.setDataInt(dataInt);
    product.setDataDouble(dataDouble);
    product.setVerified(verified);
    product.setDetails(details);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(product);

    Product foundProduct = session.find(Product.class, id);
    assertEquals(product, foundProduct);
  }

  @Test
  public void productwith_manufacturer_salesRepresentative() {
    String name = "Big Ass";
    String department = "Technical Support";
    long phone = 8004668200l;
    String email = "techsupport@bigass.com";
    String web = "http://www.bigassfans.com";

    manufacturer = new Manufacturer();
    manufacturer.setDepartment(department);
    manufacturer.setEmail(email);
    manufacturer.setName(name);
    manufacturer.setPhone(phone);
    manufacturer.setWeb(web);

    name = "Marty McFly";
    phone = 6508896222l;
    email = "marty@mcfly.com";
    web = "http://www.test.com";

    salesRepresentative = new SalesRepresentative();
    salesRepresentative.setEmail(email);
    salesRepresentative.setName(name);
    salesRepresentative.setPhone(phone);
    salesRepresentative.setWeb(web);

    product.setAccessories(accessories);
    product.setApplication(application);
    product.setCategory(category);
    product.setModel(model);
    product.setModelYear(modelYear);
    product.setMountingLocation(mountingLocation);
    product.setPicturePath(picturePath);
    product.setSeries(series);
    product.setSubCategory(subCategory);
    product.setUseType(useType);
    product.setManufacturer(manufacturer);
    product.setSalesRepresentative(salesRepresentative);
    product.setData(data);
    product.setDataInt(dataInt);
    product.setDataDouble(dataDouble);
    product.setVerified(verified);
    product.setDetails(details);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(product);

    Product foundProduct = session.find(Product.class, id);
    assertEquals(product, foundProduct);
  }
}
