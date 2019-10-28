package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.UserInfo;
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
public class UserInfoTest {

  @Resource
  private UserInfoRepository userInfoRepository;

  @Test
  public void givenManufacturer_whenSave_thenGetOK() {
    String firstName = "Jiahua";
    String lastName = "Zhang";
    String picturePath =
        "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/Colorful_spring_garden.jpg/1200px-Colorful_spring_garden.jpg";

    UserInfo userInfo = new UserInfo();
    userInfo.setFirstName(firstName);
    userInfo.setLastName(lastName);
    userInfo.setPicturePath(picturePath);

    UserInfo savedUserInfo = userInfoRepository.save(userInfo);
    assertEquals(userInfo, savedUserInfo);
  }

}
