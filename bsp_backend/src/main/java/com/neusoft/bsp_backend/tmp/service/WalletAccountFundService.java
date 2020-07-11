package com.neusoft.bsp_backend.tmp.service;

import com.neusoft.bsp_backend.tmp.entity.WalletAccountFund;

import java.util.List;
import java.util.Map;

public interface WalletAccountFundService {
    int insert(WalletAccountFund walletAccountFund);

    int update(WalletAccountFund walletAccountFund);

    int delete(int pk);

    WalletAccountFund getById(int pk);

    List<WalletAccountFund> getAllByFilter(Map<String, Object> map);

    List<WalletAccountFund> getAll();
}
