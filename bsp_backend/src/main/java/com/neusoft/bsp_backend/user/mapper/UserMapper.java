package com.neusoft.bsp_backend.user.mapper;


import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<String, User> {
}
