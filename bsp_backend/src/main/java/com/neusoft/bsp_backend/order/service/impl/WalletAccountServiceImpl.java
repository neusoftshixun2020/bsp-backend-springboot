package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.WalletAccount;
import com.neusoft.bsp_backend.order.mapper.WalletAccountMapper;
import com.neusoft.bsp_backend.order.service.WalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class WalletAccountServiceImpl implements WalletAccountService {
    @Autowired
    WalletAccountMapper walletAccountMapper;

    @Override
    public int insert(WalletAccount walletAccount) {
        return walletAccountMapper.insert(walletAccount);
    }

    @Override
    public int update(WalletAccount walletAccount) {
        return walletAccountMapper.update(walletAccount);
    }

    @Override
    public int delete(int pk) {
        return walletAccountMapper.delete(pk);
    }

    @Override
    public WalletAccount getById(int pk) {
        return walletAccountMapper.getById(pk);
    }

    @Override
    public List<WalletAccount> getAllByFilter(Map<String, Object> map) {
        return walletAccountMapper.getAllByFilter(map);
    }

    @Override
    public List<WalletAccount> getAll() {
        return walletAccountMapper.getAll();
    }
}
