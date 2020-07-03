package com.neusoft.bsp_backend.mvoinfo.mapper;

import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.mvoinfo.entity.Brand;
import com.neusoft.bsp_backend.common.base.BaseMapper;
import com.neusoft.bsp_backend.mvoinfo.service.BrandService;
import com.neusoft.bsp_backend.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface BrandMapper extends BaseMapper<Integer, Brand> {


}
