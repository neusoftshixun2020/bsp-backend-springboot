package com.neusoft.bsp_backend.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp_backend.user.entity.User;
import com.neusoft.bsp_backend.user.mapper.UserMapper;
import com.neusoft.bsp_backend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public  int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String pk) {
        return userMapper.delete(pk);
    }

    @Override
    public  User getById(String userid) {
        return userMapper.getById(userid);
    }

    @Override
    public List<User> getAllByFilter(Map<String, Object> map) {
        return userMapper.getAllByFilter(map);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public PageInfo<User> getAll(Integer pageNum, Integer pagesize) {
        return this.getAllByFilter(pageNum, pagesize, new HashMap<>());
    }

    @Override
    public PageInfo<User> getAllByFilter(Integer pageNum, Integer pagesize, Map<String, Object> map) {
        PageHelper.startPage(pageNum, pagesize, true);
        List<User> users = userMapper.getAllByFilter(map);
        return new PageInfo<>(users);
    }
}
