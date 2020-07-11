package com.neusoft.bsp_backend.tmp.service.impl;

import com.neusoft.bsp_backend.tmp.entity.CodeMaster;
import com.neusoft.bsp_backend.tmp.mapper.CodeMasterMapper;
import com.neusoft.bsp_backend.tmp.service.CodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class CodeMasterServiceImpl implements CodeMasterService {

    @Autowired
    CodeMasterMapper codeMasterMapper;

    @Override
    public int insert(CodeMaster codeMaster) {
        return codeMasterMapper.insert(codeMaster);
    }

    @Override
    public int update(CodeMaster codeMaster) {
        return codeMasterMapper.update(codeMaster);
    }

    @Override
    public int delete(int pk) {
        return codeMasterMapper.delete(pk);
    }

    @Override
    public CodeMaster getById(int pk) {
        return codeMasterMapper.getById(pk);
    }

    @Override
    public List<CodeMaster> getAllByFilter(Map<String, Object> map) {
        return codeMasterMapper.getAllByFilter(map);
    }

    @Override
    public List<CodeMaster> getAll() {
        return codeMasterMapper.getAll();
    }

}

