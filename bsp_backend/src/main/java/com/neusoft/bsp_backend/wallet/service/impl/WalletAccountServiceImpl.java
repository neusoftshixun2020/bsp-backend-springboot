package com.neusoft.bsp_backend.wallet.service.impl;

import com.neusoft.bsp_backend.wallet.entity.WalletAccount;
import com.neusoft.bsp_backend.wallet.entity.WalletAccountFund;
import com.neusoft.bsp_backend.wallet.mapper.WalletAccountFundMapper;
import com.neusoft.bsp_backend.wallet.mapper.WalletAccountMapper;
import com.neusoft.bsp_backend.wallet.service.WalletAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class WalletAccountServiceImpl implements WalletAccountService {
    @Autowired
    WalletAccountMapper walletAccountMapper;
    @Autowired
    WalletAccountFundMapper walletAccountFundMapper;

    @Override
    public int insert(WalletAccount walletAccount) {
        int i = walletAccountMapper.insert(walletAccount);
        if (i==0){
            return 0;
        }
        walletAccount.getWalletAccountFund().setBuyer_id(walletAccount.getBuyer_id());
        int i1 = walletAccountFundMapper.insert(walletAccount.getWalletAccountFund());
        if (i1==0){
            return 0;
        }
        return 1;
    }

    @Override
    public int update(WalletAccount walletAccount) {
        int i = walletAccountMapper.update(walletAccount);
        if (i==0){
            return 0;
        }
        int i1 = walletAccountFundMapper.update(walletAccount.getWalletAccountFund());
        if (i1==0){
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int pk) {
        return walletAccountMapper.delete(pk);
    }

    @Override
    public WalletAccount getById(int pk) {
        WalletAccountFund walletAccountFund = walletAccountFundMapper.getById(pk);
        WalletAccount walletAccount = walletAccountMapper.getById(pk);
        walletAccount.setWalletAccountFund(walletAccountFund);
        return walletAccount;
    }

    @Override
    public List<WalletAccount> getAllByFilter(Map<String, Object> map) {
        List<WalletAccount> walletAccounts = walletAccountMapper.getAllByFilter(map);
        for (WalletAccount walletAccount: walletAccounts){
            WalletAccountFund walletAccountFund = walletAccountFundMapper.getById(walletAccount.getBuyer_id());
            walletAccount.setWalletAccountFund(walletAccountFund);
        }
        return walletAccounts;
    }

    @Override
    public List<WalletAccount> getAll() {
        return this.getAllByFilter(new HashMap<>());
    }
}
