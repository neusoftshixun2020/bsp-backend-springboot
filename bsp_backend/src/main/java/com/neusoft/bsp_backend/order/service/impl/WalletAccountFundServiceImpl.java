package com.neusoft.bsp_backend.order.service.impl;

import com.neusoft.bsp_backend.order.entity.WalletAccountFund;
import com.neusoft.bsp_backend.order.mapper.WalletAccountFundMapper;
import com.neusoft.bsp_backend.order.service.WalletAccountFundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class WalletAccountFundServiceImpl implements WalletAccountFundService {

    @Autowired
    WalletAccountFundMapper walletAccountFundMapper;

    @Override
    public int insert(WalletAccountFund walletAccountFund) {
        return walletAccountFundMapper.insert(walletAccountFund);
    }

    @Override
    public int update(WalletAccountFund walletAccountFund) {
        return walletAccountFundMapper.update(walletAccountFund);
    }

    @Override
    public int delete(int pk) {
        return walletAccountFundMapper.delete(pk);
    }

    @Override
    public WalletAccountFund getById(int pk) {
        return walletAccountFundMapper.getById(pk);
    }

    @Override
    public List<WalletAccountFund> getAllByFilter(Map<String, Object> map) {
        return walletAccountFundMapper.getAllByFilter(map);
    }

    @Override
    public List<WalletAccountFund> getAll() {
        return walletAccountFundMapper.getAll();
    }
}
