package manage.backendjava.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import manage.backendjava.config.ExampleConfig;
import manage.backendjava.config.JPAConfig;
import manage.backendjava.entities.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfig.class, ExampleConfig.class})
@Transactional
public class UserRepositoryTest {

  @Autowired
  private UserRepository repository;

  @Autowired
  @Qualifier("null")
  private UserEntity nullUser;

  @Autowired
  @Qualifier("user")
  private UserEntity defaultUser;

  @Test
  public void load_correctly() {
    assertNotNull(repository);
    assertNotNull(nullUser);
    assertNotNull(defaultUser);
  }

  @Test
  public void save_correctly() {
    UserEntity savedNullUser = repository.save(nullUser);
    assertEquals(nullUser, savedNullUser);

    UserEntity savedDefaultUser = repository.save(defaultUser);
    assertEquals(defaultUser, savedDefaultUser);
  }

  @Test
  public void exists_by_username_work() {
    assertFalse(repository.existsByUsername(defaultUser.getUsername()));
    repository.save(defaultUser);
    assertTrue(repository.existsByUsername(defaultUser.getUsername()));
  }

  @Test
  public void find_by_username_work() {
    assertTrue(repository.findByUsername(defaultUser.getUsername()).isEmpty());
    repository.save(defaultUser);
    assertFalse(repository.findByUsername(defaultUser.getUsername()).isEmpty());
  }

}
