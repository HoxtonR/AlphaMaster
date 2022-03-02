package com.hoxtonr.function.future.account;

import com.client.RequestOptions;
import com.client.SyncRequestClient;
import com.client.model.trade.AccountBalance;
import com.hoxtonr.apis.binanceapi.DefaultAccount;

import java.util.List;

public class BinanceSwapAccount {
    private List<AccountBalance> getBalance(){
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(DefaultAccount.getInstance().getApikey(), DefaultAccount.getInstance().getSecretkey(),
                options);
        return syncRequestClient.getBalance();
    }
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(DefaultAccount.getInstance().getApikey(), DefaultAccount.getInstance().getSecretkey(),
                options);
        System.out.println(syncRequestClient.getBalance());
    }

}
