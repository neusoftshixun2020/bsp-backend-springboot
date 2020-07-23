package com.neusoft.bsp_backend.bvo.mapper;

import com.neusoft.bsp_backend.wallet.entity.WalletAccount;
import com.neusoft.bsp_backend.wallet.entity.WalletAccountFund;
import com.neusoft.bsp_backend.wallet.entity.WalletTransactionRecord;
import com.neusoft.bsp_backend.wallet.mapper.WalletAccountMapper;
import com.neusoft.bsp_backend.wallet.mapper.WalletTransactionRecordMapper;
import com.neusoft.bsp_backend.wallet.service.WalletAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreMapperTest {
    @Autowired
    StoreMapper storeMapper;
    @Autowired
    WalletAccountMapper walletAccountMapper;

    @Autowired
    WalletAccountService walletAccountService;
    @Autowired
    WalletTransactionRecordMapper walletTransactionRecordMapper;
    @Test
    void contextLoads() {
        WalletAccount walletAccount = new WalletAccount();
        WalletAccountFund walletAccountFund = new WalletAccountFund();
        walletAccount.setWalletAccountFund(walletAccountFund);
        walletAccountService.insert(walletAccount);
    }
    @Test
    void contextloads1(){
        WalletTransactionRecord walletTransactionRecord = new WalletTransactionRecord();
        walletTransactionRecordMapper.insert(walletTransactionRecord);
    }

}