package com.hoxtonr.function.spot.account;


import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiFutureRestClient;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.FutureTransferType;
import com.binance.api.client.domain.account.AssetBalance;
import com.hoxtonr.apis.binanceapi.AccountApi;
import com.hoxtonr.apis.binanceapi.DefaultAccount;
import com.hoxtonr.function.spot.model.AccountBalance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BinanceSpotAccount implements Account {
    private final String Username;
    private final String apikey;
    private final String secretkey;
    public BinanceSpotAccount(){
        Username = "HoxtonR";
        apikey = DefaultAccount.getInstance().getApikey();
        secretkey = DefaultAccount.getInstance().getSecretkey();
    }
    public BinanceSpotAccount(AccountApi acc){
        this.apikey = acc.getApikey();
        this.secretkey  = acc.getApikey();
        this.Username = acc.getUsername();
    }
    @Override
    public  BigDecimal accountTotalBalance() {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey,secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        com.binance.api.client.domain.account.Account account = client.getAccount(60_000L, System.currentTimeMillis());
        return StringTransferBigdecimal(account.getAssetBalance("USDT").getFree());
    }

    @Override
    public BigDecimal accountBalance(String cointype) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey,secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        com.binance.api.client.domain.account.Account account = client.getAccount(60_000L, System.currentTimeMillis());
        return StringTransferBigdecimal(account.getAssetBalance(cointype).getFree());
    }

    @Override
    public List<AccountBalance> accountBalance() {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        List<AccountBalance> balanceList = new ArrayList<>();
        com.binance.api.client.domain.account.Account account = client.getAccount();
        for (AssetBalance a : account.getBalances()) {
            if(Double.parseDouble(a.getFree())>0.01){
                AccountBalance accountBalance = new AccountBalance();
                accountBalance.setSymbol(a.getAsset());
                accountBalance.setFree(StringTransferBigdecimal(a.getFree()));
                accountBalance.setLocked(StringTransferBigdecimal(a.getLocked()));
                balanceList.add(accountBalance);
            }
        }
        return balanceList;
    }

    @Override
    public String accountID() {
        return Username;
    }

    @Override
    public void transferBalance_STOU(BigDecimal amount) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiFutureRestClient client = factory.newFutureRestClient();
        if(amount.doubleValue() < 1){
            return;
        }
        BigDecimal b = BigDecimal.valueOf(amount.doubleValue()).setScale(4, RoundingMode.DOWN);
        client.transferFuture("USDT",String.valueOf(amount), FutureTransferType.SPOT_TO_USDTSWAP);

    }

    @Override
    public void transferBalance_UTOS(BigDecimal amount) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiFutureRestClient client = factory.newFutureRestClient();
        if(amount.doubleValue() < 1){
            return;
        }
        BigDecimal b = BigDecimal.valueOf(amount.doubleValue()).setScale(4, RoundingMode.DOWN);
        client.transferFuture("USDT",String.valueOf(amount), FutureTransferType.USDTSWAP_TO_SPOT);
    }
    public BigDecimal StringTransferBigdecimal(String para){
        return BigDecimal.valueOf(Double.parseDouble(para));
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("======账户信息======").append("\n");
        sb.append("账户ID: ").append(accountID()).append("\n");
        sb.append("账户USDT估值: ").append(accountTotalBalance()).append("\n");
        sb.append("账户余额: ").append(accountBalance()).append("\n");
        sb.append("==================");
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
