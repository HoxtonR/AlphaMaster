package com.hoxtonr.crypto.binance.spot;

import com.hoxtonr.crypto.binance.models.AccountBalance;

import java.math.BigDecimal;
import java.util.List;

public interface Account {
    public BigDecimal accountTotalBalance();

    public BigDecimal accountBalance(String cointype);

    public List<AccountBalance> accountBalance();

    public String  accountID();

    public void transferBalance_STOU(BigDecimal amount);

    public void transferBalance_UTOS(BigDecimal amount);
}
