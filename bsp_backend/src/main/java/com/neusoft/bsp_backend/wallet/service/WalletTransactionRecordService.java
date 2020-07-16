package com.neusoft.bsp_backend.wallet.service;

import com.neusoft.bsp_backend.wallet.entity.WalletTransactionRecord;

import java.util.List;
import java.util.Map;

public interface WalletTransactionRecordService {
    int insert(WalletTransactionRecord walletTransactionRecord);

    int update(WalletTransactionRecord walletTransactionRecord);

    int delete(int pk);

    WalletTransactionRecord getById(int pk);

    List<WalletTransactionRecord> getAllByFilter(Map<String, Object> map);

    List<WalletTransactionRecord> getAll();
}
