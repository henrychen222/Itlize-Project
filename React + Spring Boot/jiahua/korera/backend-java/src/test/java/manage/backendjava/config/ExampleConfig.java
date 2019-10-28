package manage.backendjava.config;

import java.util.Date;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import manage.backendjava.entities.UserEntity;

@Configuration
public class ExampleConfig {

  @Bean
  @Qualifier("null")
  public UserEntity userEntityNull() {
    UserEntity user = new UserEntity();

    return user;
  }

  @Bean
  @Qualifier("user")
  public UserEntity userEntityInstance() {
    UserEntity user = new UserEntity();
    user.setUsername("username");
    user.setPassword("password");
    user.setJoined(new Date());

    return user;
  }

}
