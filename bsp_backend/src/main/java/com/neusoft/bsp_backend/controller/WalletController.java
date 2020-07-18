package com.neusoft.bsp_backend.controller;

import com.neusoft.bsp_backend.bvo.entity.DropShipper;
import com.neusoft.bsp_backend.bvo.entity.WishList;
import com.neusoft.bsp_backend.common.base.BaseController;
import com.neusoft.bsp_backend.common.base.BaseModel;
import com.neusoft.bsp_backend.common.base.BaseModelJson;
import com.neusoft.bsp_backend.common.exception.BusinessException;
import com.neusoft.bsp_backend.common.image.service.ImageService;
import com.neusoft.bsp_backend.common.validationGroup.DeleteGroup;
import com.neusoft.bsp_backend.common.validationGroup.InsertGroup;
import com.neusoft.bsp_backend.common.validationGroup.UpdateGroup;
import com.neusoft.bsp_backend.user.entity.User;
import com.neusoft.bsp_backend.wallet.entity.WalletAccount;
import com.neusoft.bsp_backend.wallet.entity.WalletAccountFund;
import com.neusoft.bsp_backend.wallet.entity.WalletTransactionAudit;
import com.neusoft.bsp_backend.wallet.entity.WalletTransactionRecord;
import com.neusoft.bsp_backend.wallet.service.WalletAccountService;
import com.neusoft.bsp_backend.wallet.service.WalletTransactionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/wallet")
public class WalletController extends BaseController {
    @Autowired
    WalletAccountService walletAccountService;
    @Autowired
    WalletTransactionRecordService walletTransactionRecordService;

    @PostMapping("/getFlow")
    public BaseModelJson<List<WalletTransactionRecord>> getFlow(){
        BaseModelJson<List<WalletTransactionRecord>> result = new BaseModelJson<>();
        Map<String, Object> map = new HashMap<>();
        //map.put("buyer_id", walletAccount.getBuyer_id());
        result.code = 200;
        result.data = walletTransactionRecordService.getAllByFilter(map);
        return result;
    }

    @PostMapping("/auditFlow")
    public BaseModel auditFlow(@Validated({UpdateGroup.class}) @RequestBody WalletTransactionRecord walletTransactionRecord, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{walletTransactionRecord.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = walletTransactionRecordService.update(walletTransactionRecord);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.UPDATE_FAIL;
            }
        }
    }

    @PostMapping("/checkAccount")
    public BaseModelJson<WalletAccount> checkAccount(@RequestBody WalletAccount walletAccount) {
        Map<String, Object> map = new HashMap<>();
        map.put("account_name", walletAccount.getAccount_name());
        map.put("password", walletAccount.getPassword());
        List<WalletAccount> walletAccounts = walletAccountService.getAllByFilter(map);
        if (walletAccounts.size() == 0) {
            throw BusinessException.NOT_EXISTS;
        } else {
            BaseModelJson<WalletAccount> result = new BaseModelJson();
            result.code = 200;
            result.data = walletAccounts.get(0);
            return result;
        }
    }

    @PostMapping("/addAccount")
    public BaseModel addAccount(@Validated({InsertGroup.class}) @RequestBody WalletAccount walletAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.INSERT_FAIL.newInstance("504", this.getErrorResponse(bindingResult), new Object[]{walletAccount.toString()});
        } else {
            BaseModel result = new BaseModel();
            int i = walletAccountService.insert(walletAccount);
            if (i == 1) {
                result.code = 200;
                return result;
            } else {
                throw BusinessException.INSERT_FAIL;
            }
        }
    }

    @PostMapping("/getTransactionalRecord")
    public BaseModelJson<List<WalletTransactionRecord>> getTransactionalRecord(@RequestBody WalletAccount walletAccount){
        BaseModelJson<List<WalletTransactionRecord>> result = new BaseModelJson<>();
        Map<String, Object> map = new HashMap<>();
        map.put("buyer_id", walletAccount.getBuyer_id());
        result.code = 200;
        result.data = walletTransactionRecordService.getAllByFilter(map);
        return result;
    }

    @PostMapping("/withdraw")
    public BaseModel withdraw(@Validated({UpdateGroup.class}) @RequestBody WalletAccount walletAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{walletAccount.toString()});
        } else {
            BaseModel result = new BaseModel();
            Map<String, Object> map = new HashMap<>();
            map.put("account_name", walletAccount.getAccount_name());
            map.put("password", walletAccount.getPassword());
            List<WalletAccount> walletAccounts = walletAccountService.getAllByFilter(map);
            if (walletAccounts.size() == 0) {
                throw BusinessException.NOT_EXISTS;
            } else {
                WalletTransactionAudit walletTransactionAudit = new WalletTransactionAudit();
                WalletTransactionRecord walletTransactionRecord = new WalletTransactionRecord();
                WalletAccountFund walletAccountFund = walletAccount.getWalletAccountFund();

                walletTransactionAudit.setAvailable_money_before(walletAccountFund.getAvailable_money());
                walletTransactionAudit.setCreate_time(new Date());
                walletTransactionAudit.setDepositing_money_before(walletAccountFund.getDepositing_money());
                walletTransactionAudit.setBuyer_id(walletAccount.getBuyer_id());
                walletTransactionAudit.setStatus(2);
                walletTransactionAudit.setOperate_type(2);
                walletTransactionAudit.setWithdrawing_money_before(walletAccountFund.getWithdrawing_money());
                walletTransactionAudit.setOperate_money(walletAccountFund.getWithdrawing_money());

                walletTransactionRecord.setAccount_name(walletAccount.getAccount_name());
                walletTransactionRecord.setBuyer_id(walletAccount.getBuyer_id());
                walletTransactionRecord.setCreate_time(new Date());
                walletTransactionRecord.setTransaction_type(2);
                walletTransactionRecord.setFinance_type(2);
                walletTransactionRecord.setTransaction_money(walletAccountFund.getWithdrawing_money());
                walletTransactionRecord.setStatus(2);

                walletAccountFund.setAvailable_money(walletAccountFund.getAvailable_money().subtract(walletAccountFund.getWithdrawing_money()));
                walletAccountFund.setWithdrawing_money(BigDecimal.valueOf(0));
                walletAccount.setWalletAccountFund(walletAccountFund);
                int i = walletAccountService.update(walletAccount);
                if (i == 1) {
                    walletTransactionAudit.setAvailable_money_after(walletAccountFund.getAvailable_money());
                    walletTransactionAudit.setDepositing_money_after(walletAccountFund.getDepositing_money());
                    walletTransactionAudit.setWithdrawing_money_after(walletAccountFund.getWithdrawing_money());
                    walletTransactionRecord.setWalletTransactionAudit(walletTransactionAudit);
                    int j = walletTransactionRecordService.insert(walletTransactionRecord);
                    if (j==1){
                        result.code = 200;
                        return result;
                    }else {
                        throw BusinessException.INSERT_FAIL;
                    }
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            }
        }
    }

    @PostMapping("/getFund")
    public BaseModelJson<WalletAccountFund> getFund(@RequestBody WalletAccount walletAccount) {
        WalletAccount walletAccount1 = walletAccountService.getById(walletAccount.getBuyer_id());
        if (walletAccount1 == null) {
            throw BusinessException.NOT_EXISTS;
        } else {
            BaseModelJson<WalletAccountFund> result = new BaseModelJson();
            result.code = 200;
            result.data = walletAccount1.getWalletAccountFund();
            return result;
        }
    }

    @PostMapping("/deposit")
    public BaseModel deposit(@Validated({UpdateGroup.class}) @RequestBody WalletAccount walletAccount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{walletAccount.toString()});
        } else {
            BaseModel result = new BaseModel();
            Map<String, Object> map = new HashMap<>();
            map.put("account_name", walletAccount.getAccount_name());
            map.put("password", walletAccount.getPassword());
            List<WalletAccount> walletAccounts = walletAccountService.getAllByFilter(map);
            if (walletAccounts.size() == 0) {
                throw BusinessException.NOT_EXISTS;
            } else {
                WalletAccountFund walletAccountFund = walletAccount.getWalletAccountFund();
                WalletTransactionAudit walletTransactionAudit = new WalletTransactionAudit();
                WalletTransactionRecord walletTransactionRecord = new WalletTransactionRecord();

                walletTransactionAudit.setAvailable_money_before(walletAccountFund.getAvailable_money());
                walletTransactionAudit.setCreate_time(new Date());
                walletTransactionAudit.setDepositing_money_before(walletAccountFund.getDepositing_money());
                walletTransactionAudit.setBuyer_id(walletAccount.getBuyer_id());
                walletTransactionAudit.setStatus(2);
                walletTransactionAudit.setOperate_type(1);
                walletTransactionAudit.setWithdrawing_money_before(walletAccountFund.getWithdrawing_money());
                walletTransactionAudit.setOperate_money(walletAccountFund.getDepositing_money());

                walletTransactionRecord.setAccount_name(walletAccount.getAccount_name());
                walletTransactionRecord.setBuyer_id(walletAccount.getBuyer_id());
                walletTransactionRecord.setCreate_time(new Date());
                walletTransactionRecord.setTransaction_type(1);
                walletTransactionRecord.setFinance_type(1);
                walletTransactionRecord.setTransaction_money(walletAccountFund.getDepositing_money());
                walletTransactionRecord.setStatus(2);

                walletAccountFund.setAvailable_money(walletAccountFund.getAvailable_money().add(walletAccountFund.getDepositing_money()));
                walletAccountFund.setDepositing_money(BigDecimal.valueOf(0));
                walletAccount.setWalletAccountFund(walletAccountFund);
                int i = walletAccountService.update(walletAccount);
                if (i == 1) {
                    walletTransactionAudit.setAvailable_money_after(walletAccountFund.getAvailable_money());
                    walletTransactionAudit.setDepositing_money_after(walletAccountFund.getDepositing_money());
                    walletTransactionAudit.setWithdrawing_money_after(walletAccountFund.getWithdrawing_money());
                    walletTransactionRecord.setWalletTransactionAudit(walletTransactionAudit);
                    int j = walletTransactionRecordService.insert(walletTransactionRecord);
                    if (j==1){
                        result.code = 200;
                        return result;
                    }else {
                        throw BusinessException.INSERT_FAIL;
                    }
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            }
        }
    }
    @PostMapping("/pay")
    public BaseModel pay(@Validated({UpdateGroup.class}) @RequestBody WalletAccount walletAccount, int man_id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{walletAccount.toString()});
        } else {
            BaseModel result = new BaseModel();
            Map<String, Object> map = new HashMap<>();
            map.put("account_name", walletAccount.getAccount_name());
            map.put("password", walletAccount.getPassword());
            List<WalletAccount> walletAccounts = walletAccountService.getAllByFilter(map);
            if (walletAccounts.size() == 0) {
                throw BusinessException.NOT_EXISTS;
            } else {
                WalletAccount walletAccount1 = walletAccounts.get(0);
                WalletAccountFund walletAccountFund = walletAccount1.getWalletAccountFund();
                walletAccountFund.setWithdrawing_money(walletAccount.getWalletAccountFund().getWithdrawing_money());
                WalletTransactionAudit walletTransactionAudit = new WalletTransactionAudit();
                WalletTransactionRecord walletTransactionRecord = new WalletTransactionRecord();

                walletTransactionAudit.setAvailable_money_before(walletAccountFund.getAvailable_money());
                walletTransactionAudit.setCreate_time(new Date());
                walletTransactionAudit.setDepositing_money_before(walletAccountFund.getDepositing_money());
                walletTransactionAudit.setBuyer_id(walletAccount1.getBuyer_id());
                walletTransactionAudit.setStatus(2);
                walletTransactionAudit.setOperate_type(3);
                walletTransactionAudit.setWithdrawing_money_before(walletAccountFund.getWithdrawing_money());
                walletTransactionAudit.setOperate_money(walletAccountFund.getWithdrawing_money());

                walletTransactionRecord.setAccount_name(walletAccount1.getAccount_name());
                walletTransactionRecord.setBuyer_id(walletAccount1.getBuyer_id());
                walletTransactionRecord.setCreate_time(new Date());
                walletTransactionRecord.setTransaction_type(3);
                walletTransactionRecord.setFinance_type(2);
                walletTransactionRecord.setTransaction_money(walletAccountFund.getWithdrawing_money());
                walletTransactionRecord.setStatus(2);

                Map<String, Object> map1 = new HashMap<>();
                map1.put("man_id", man_id);
                List<WalletAccount> man_walletAccounts = walletAccountService.getAllByFilter(map1);
                if (man_walletAccounts.size() == 0){
                    throw BusinessException.NOT_EXISTS;
                }else {
                    WalletAccount man_wallet = man_walletAccounts.get(0);
                    man_wallet.getWalletAccountFund().setAvailable_money(man_wallet.getWalletAccountFund().getAvailable_money().add(walletAccountFund.getWithdrawing_money()));
                    walletAccountFund.setAvailable_money(walletAccountFund.getAvailable_money().subtract(walletAccountFund.getWithdrawing_money()));
                    walletAccountFund.setWithdrawing_money(BigDecimal.valueOf(0));
                    walletAccount1.setWalletAccountFund(walletAccountFund);
                    int i = walletAccountService.update(walletAccount1);
                    int l = walletAccountService.update(man_wallet);
                    if (i == 1 && l==1) {
                        walletTransactionAudit.setAvailable_money_after(walletAccountFund.getAvailable_money());
                        walletTransactionAudit.setDepositing_money_after(walletAccountFund.getDepositing_money());
                        walletTransactionAudit.setWithdrawing_money_after(walletAccountFund.getWithdrawing_money());
                        walletTransactionRecord.setWalletTransactionAudit(walletTransactionAudit);
                        int j = walletTransactionRecordService.insert(walletTransactionRecord);
                        if (j==1){
                            result.code = 200;
                            return result;
                        }else {
                            throw BusinessException.INSERT_FAIL;
                        }
                    } else {
                        throw BusinessException.UPDATE_FAIL;
                    }
                }
            }
        }
    }
    @PostMapping("/changePassword")
    public BaseModel changePassword(@Validated({UpdateGroup.class}) @RequestBody WalletAccount walletAccount, String newPassword, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw BusinessException.USERID_NULL_ERROR.newInstance("504", this.getErrorResponse(bindingResult),
                    new Object[]{walletAccount.toString()});
        } else {
            BaseModel result = new BaseModel();
            Map<String, Object> map = new HashMap<>();
            map.put("account_name", walletAccount.getAccount_name());
            map.put("password", walletAccount.getPassword());
            List<WalletAccount> walletAccounts = walletAccountService.getAllByFilter(map);
            if (walletAccounts.size() == 0){
                throw BusinessException.NOT_EXISTS;
            }else {
                walletAccount.setPassword(newPassword);
                int i = walletAccountService.update(walletAccount);
                if (i == 1) {
                    result.code = 200;
                    return result;
                } else {
                    throw BusinessException.UPDATE_FAIL;
                }
            }
        }
    }
}
