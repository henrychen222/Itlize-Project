package com.itlize.marketplace.repositories;

import com.itlize.marketplace.entities.UserInfo;
import com.itlize.marketplace.entities.UserLogin;

public interface UserInfoRepository extends BaseRepository<UserInfo> {

  UserInfo findByUserLogin(UserLogin userLogin);

}
