package com.neusoft.bsp_backend.order.service;

import com.neusoft.bsp_backend.order.entity.WalletAccount;

import java.util.List;
import java.util.Map;

public interface WalletAccountService {
    int insert(WalletAccount walletAccount);

    int update(WalletAccount walletAccount);

    int delete(int pk);

    WalletAccount getById(int pk);

    List<WalletAccount> getAllByFilter(Map<String, Object> map);

    List<WalletAccount> getAll();
}
