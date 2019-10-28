package com.itlize.marketplace.repositories;

import java.util.List;
import com.itlize.marketplace.entities.UserLogin;

public interface UserLoginRepository extends BaseRepository<UserLogin> {

  List<UserLogin> findByUsername(String username);

  List<UserLogin> findByEmail(String email);

  long countByUsername(String username);

  long countByEmail(String email);

}
