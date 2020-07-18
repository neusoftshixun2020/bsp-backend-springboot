package com.neusoft.bsp_backend.user.mapper;

import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.user.entity.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionMapper extends BaseMapper<Integer, Permission> {
}
