package com.neusoft.bsp_backend.bvo.mapper;

import com.neusoft.bsp_backend.wallet.entity.WalletAccount;
import com.neusoft.bsp_backend.wallet.entity.WalletTransactionRecord;
import com.neusoft.bsp_backend.wallet.mapper.WalletAccountMapper;
import com.neusoft.bsp_backend.wallet.mapper.WalletTransactionRecordMapper;
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
    WalletTransactionRecordMapper walletTransactionRecordMapper;
    @Test
    void contextLoads() {
        WalletAccount walletAccount = new WalletAccount();
        walletAccountMapper.insert(walletAccount);
    }
    @Test
    void contextloads1(){
        WalletTransactionRecord walletTransactionRecord = new WalletTransactionRecord();
        walletTransactionRecordMapper.insert(walletTransactionRecord);
    }

}