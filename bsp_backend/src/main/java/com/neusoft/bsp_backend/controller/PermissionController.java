package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.user.entity.ChildrenRoute;
import com.neusoft.bsp_backend.user.entity.ParentRoute;
import com.neusoft.bsp_backend.user.entity.Permission;
import com.neusoft.bsp_backend.user.entity.Role;
import com.neusoft.bsp_backend.user.service.ChildrenRouteService;
import com.neusoft.bsp_backend.user.service.ParentRouteService;
import com.neusoft.bsp_backend.user.service.PermissionService;
import com.neusoft.bsp_backend.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    PermissionService permissionService;

    @Autowired
    ParentRouteService parentRouteService;

    @Autowired
    ChildrenRouteService childrenRouteService;

    @Autowired
    RoleService roleService;

    @PostMapping("getPermissionRoute")
    public BaseModelJson<List<Permission>> getPermissionRoute(@RequestBody Role role) {
        Map<String, Object> map = new HashMap<>();
        map.put("role_id", role.getRole_id());
        List<Permission> permissions = permissionService.getAllByFilter(map);
        for (Permission permission:permissions) {
            ParentRoute parentRoute = parentRouteService.getById(permission.getParent_route_id());
            ChildrenRoute childrenRoute = childrenRouteService.getById(permission.getRoute_id());
            permission.setParentRoute(parentRoute);
            permission.setChildrenRoute(childrenRoute);
        }
        BaseModelJson<List<Permission>> result = new BaseModelJson<>();
        result.code = 200;
        result.data = permissions;
        return result;
    }

    @GetMapping("getAllRoles")
    public BaseModelJson<List<Role>> getAllRoles() {
       List<Role> roles = roleService.getAll();
       BaseModelJson<List<Role>> result = new BaseModelJson<>();
       result.data = roles;
       result.code = 200;
       return result;
    }

    @PostMapping("addOrUpdateRole")
    public BaseModel addOrUpdateRole(@RequestBody Role role, String operationFlag, BindingResult bindingResult) {
        System.out.println(role.toString());
        System.out.println(operationFlag);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{role.toString()});
        } else {
            BaseModel result = new BaseModel();
            if (operationFlag.equals("add")) {
                int i = roleService.insert(role);
                if (i == 1) {
                    result.code = 200;
                    result.message = "add success";
                    return result;
                } else {
                    throw BusinessException.INSERT_FAIL;
                }
            } else if (operationFlag.equals("update")) {
                int j = roleService.update(role);
                if (j == 1) {
                    result.code = 200;
                    result.message = "update success";
                    return result;
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            } else {
                throw BusinessException.OPERATION_FAIL;
            }
        }
    }

    @PostMapping("/deleteRole")
    public BaseModel deleteRole(@RequestBody Role role, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{role.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = roleService.delete(role.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }

    @PostMapping("/getAllPermissions")
    public BaseModelJson<List<Permission>> getAllPermissions(@RequestBody Role role) {
       Map<String, Object> map = new HashMap<>();
       map.put("role_id", role.getRole_id());
       List<Permission> permissions = permissionService.getAllByFilter(map);
       for (Permission permission:permissions) {
           ParentRoute parentRoute = parentRouteService.getById(permission.getParent_route_id());
           permission.setParentRoute(parentRoute);
           ChildrenRoute childrenRoute = childrenRouteService.getById(permission.getRoute_id());
           permission.setChildrenRoute(childrenRoute);
       }
       BaseModelJson<List<Permission>> result = new BaseModelJson<>();
       result.data = permissions;
       result.code = 200;
       return result;
    }



    @PostMapping("getAllParentRoute")
    public BaseModelJson<List<ParentRoute>> getAllParentRoute() {
        List<ParentRoute> parentRoutes = parentRouteService.getAll();
        BaseModelJson<List<ParentRoute>> result = new BaseModelJson<>();
        result.data = parentRoutes;
        result.code = 200;
        return result;
    }

    @PostMapping("getAllChildrenRoute")
    public BaseModelJson<List<ChildrenRoute>> getAllChildrenRoute() {
        List<ChildrenRoute> childrenRoutes = childrenRouteService.getAll();
        BaseModelJson<List<ChildrenRoute>> result = new BaseModelJson<>();
        result.data = childrenRoutes;
        result.code = 200;
        return result;
    }

    @PostMapping("getChildrenRouteByParent")
    public BaseModelJson<List<ChildrenRoute>> getChildrenRouteByParent(@RequestBody ParentRoute parentRoute) {
        Map<String, Object> map = new HashMap<>();
        map.put("parent_route_id", parentRoute.getParent_route_id());
        List<ChildrenRoute> childrenRoutes = childrenRouteService.getAllByFilter(map);
        BaseModelJson<List<ChildrenRoute>> result = new BaseModelJson<>();
        result.data = childrenRoutes;
        result.code = 200;
        return result;
    }

    @PostMapping("addOrUpdatePermission")
    public BaseModel addOrUpdatePermission(@RequestBody Permission permission, String operationFlag, BindingResult bindingResult) {
        System.out.println(permission.toString());
        System.out.println(operationFlag);
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{permission.toString()});
        } else {
            BaseModel result = new BaseModel();
            if (operationFlag.equals("add")) {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("role_id", permission.getRole_id());
                map1.put("parent_route_id", permission.getParent_route_id());
                map1.put("route_id", null);
                List<Permission> permissions = permissionService.getAllByFilter(map1);
                if (permissions.size() > 0) {
                    throw BusinessException.DUPLICATE_PATH;
                }
                Map<String, Object> map2 = new HashMap<>();
                map2.put("role_id", permission.getRole_id());
                map2.put("parent_route_id", permission.getParent_route_id());
                map2.put("route_id", permission.getRoute_id());
                List<Permission> permissions2 = permissionService.getAllByFilter(map2);
                if (permissions2.size() > 0) {
                    throw BusinessException.DUPLICATE_PATH;
                }
                int i = permissionService.insert(permission);
                if (i == 1) {
                    result.code = 200;
                    result.message = "add success";
                    return result;
                } else {
                    throw BusinessException.INSERT_FAIL;
                }
            } else if (operationFlag.equals("update")) {
                Map<String, Object> map1 = new HashMap<>();
                map1.put("role_id", permission.getRole_id());
                map1.put("parent_route_id", permission.getParent_route_id());
                map1.put("route_id", null);
                List<Permission> permissions = permissionService.getAllByFilter(map1);
                for (Permission permission1:permissions) {
                    if (permission1.getId() != permission.getId())
                        throw BusinessException.DUPLICATE_PATH;
                }
                Map<String, Object> map2 = new HashMap<>();
                map2.put("role_id", permission.getRole_id());
                map2.put("parent_route_id", permission.getParent_route_id());
                map2.put("route_id", permission.getRoute_id());
                List<Permission> permissions2 = permissionService.getAllByFilter(map2);
                for (Permission permission2: permissions2) {
                    if (permission2.getId() != permission.getId())
                        throw BusinessException.DUPLICATE_PATH;
                }
                int j = permissionService.update(permission);
                if (j == 1) {
                    result.code = 200;
                    result.message = "update success";
                    return result;
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            } else {
                throw BusinessException.OPERATION_FAIL;
            }
        }
    }


    @PostMapping("/deletePermission")
    public BaseModel deletePermission(@RequestBody Permission permission, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{permission.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = permissionService.delete(permission.getId());
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.DELETE_FAIL;
            }
        }
    }
}
