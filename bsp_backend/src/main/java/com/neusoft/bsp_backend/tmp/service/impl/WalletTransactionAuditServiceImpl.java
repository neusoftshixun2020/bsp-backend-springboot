package com.neusoft.bsp_backend.tmp.service.impl;

import com.neusoft.bsp_backend.common.base.BaseEntity;
import com.neusoft.bsp_backend.tmp.entity.WalletTransactionAudit;
import com.neusoft.bsp_backend.tmp.mapper.WalletTransactionAuditMapper;
import com.neusoft.bsp_backend.tmp.service.WalletTransactionAuditService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class WalletTransactionAuditServiceImpl implements WalletTransactionAuditService {

    @Autowired
    WalletTransactionAuditMapper walletTransactionAuditMapper;

    @Override
    public int insert(WalletTransactionAudit walletTransactionAudit) {
        return walletTransactionAuditMapper.insert(walletTransactionAudit);
    }

    @Override
    public int update(WalletTransactionAudit walletTransactionAudit) {
        return walletTransactionAuditMapper.update(walletTransactionAudit);
    }

    @Override
    public int delete(int pk) {
        return walletTransactionAuditMapper.delete(pk);
    }

    @Override
    public WalletTransactionAudit getById(int pk) {
        return walletTransactionAuditMapper.getById(pk);
    }

    @Override
    public List<WalletTransactionAudit> getAllByFilter(Map<String, Object> map) {
        return walletTransactionAuditMapper.getAllByFilter(map);
    }

    @Override
    public List<WalletTransactionAudit> getAll() {
        return walletTransactionAuditMapper.getAll();
    }
}
