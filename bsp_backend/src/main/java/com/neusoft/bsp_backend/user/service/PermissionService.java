package com.neusoft.bsp_backend.user.service;


import com.neusoft.bsp_backend.user.entity.Permission;

import java.util.List;
import java.util.Map;


public interface PermissionService {

    int insert(Permission permission);

    int update(Permission permission);

    int delete(int pk);

    Permission getById(int permission_id);

    List<Permission> getAllByFilter(Map<String, Object> map);

    List<Permission> getAll();

}
