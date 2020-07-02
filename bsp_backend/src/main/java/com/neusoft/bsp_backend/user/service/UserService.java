package com.neusoft.bsp_backend.user.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.user.entity.User;

import java.util.List;
import java.util.Map;


public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(String pk);

    User getById(String userid);

    List<User> getAllByFilter(Map<String, Object> map);

    List<User> getAll();

    PageInfo<User> getAll(Integer pageNum, Integer pagesize);

    PageInfo<User> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map);
}
