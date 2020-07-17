package com.neusoft.bsp_backend.wallet.service.impl;

import com.neusoft.bsp_backend.wallet.entity.WalletTransactionAudit;
import com.neusoft.bsp_backend.wallet.entity.WalletTransactionRecord;
import com.neusoft.bsp_backend.wallet.mapper.WalletTransactionAuditMapper;
import com.neusoft.bsp_backend.wallet.mapper.WalletTransactionRecordMapper;
import com.neusoft.bsp_backend.wallet.service.WalletTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class WalletTransactionRecordServiceImpl implements WalletTransactionRecordService {
    @Autowired
    WalletTransactionRecordMapper walletTransactionRecordMapper;
    @Autowired
    WalletTransactionAuditMapper walletTransactionAuditMapper;

    @Override
    public int insert(WalletTransactionRecord walletTransactionRecord) {
        int i = walletTransactionRecordMapper.insert(walletTransactionRecord);
        if (i==0){
            return 0;
        }
        walletTransactionRecord.getWalletTransactionAudit().setTransaction_id(walletTransactionRecord.getTransaction_id());
        int i1 = walletTransactionAuditMapper.insert(walletTransactionRecord.getWalletTransactionAudit());
        if (i1==0){
            return 0;
        }
        return 1;
    }

    @Override
    public int update(WalletTransactionRecord walletTransactionRecord) {
        int i = walletTransactionRecordMapper.update(walletTransactionRecord);
        if (i==0){
            return 0;
        }
        int i1 = walletTransactionAuditMapper.update(walletTransactionRecord.getWalletTransactionAudit());
        if (i1==0){
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(int pk) {
        return walletTransactionRecordMapper.delete(pk);
    }

    @Override
    public WalletTransactionRecord getById(int pk) {
        WalletTransactionRecord walletTransactionRecord = walletTransactionRecordMapper.getById(pk);
        WalletTransactionAudit walletTransactionAudit = walletTransactionAuditMapper.getById(pk);
        walletTransactionRecord.setWalletTransactionAudit(walletTransactionAudit);
        return walletTransactionRecord;
    }

    @Override
    public List<WalletTransactionRecord> getAllByFilter(Map<String, Object> map) {
        List<WalletTransactionRecord> walletTransactionRecords = walletTransactionRecordMapper.getAllByFilter(map);
        for (WalletTransactionRecord walletTransactionRecord: walletTransactionRecords){
            WalletTransactionAudit walletTransactionAudit = walletTransactionAuditMapper.getById(walletTransactionRecord.getTransaction_id());
            walletTransactionRecord.setWalletTransactionAudit(walletTransactionAudit);
        }
        return walletTransactionRecords;
    }

    @Override
    public List<WalletTransactionRecord> getAll() {
        return this.getAllByFilter(new HashMap<>());
    }
}
