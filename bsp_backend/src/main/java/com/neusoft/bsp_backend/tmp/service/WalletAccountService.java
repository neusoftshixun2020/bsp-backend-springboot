package com.neusoft.bsp_backend.tmp.service;

import com.neusoft.bsp_backend.tmp.entity.WalletAccount;

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
