package manage.backendjava.repositories;

import java.util.List;
import manage.backendjava.entities.UserEntity;

public interface UserRepository extends BaseRepository<UserEntity> {

  Boolean existsByUsername(String username);

  List<UserEntity> findByUsername(String username);

}
