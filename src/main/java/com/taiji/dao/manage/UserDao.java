package com.taiji.dao.manage;

import com.taiji.entity.manage.UserEntity;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Sleeb on 2017/4/19.
 */
public interface UserDao {

    UserEntity getUser(Long userId);

}
