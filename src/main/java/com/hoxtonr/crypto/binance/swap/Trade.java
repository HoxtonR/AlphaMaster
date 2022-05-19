package com.hoxtonr.crypto.binance.swap;


import com.hoxtonr.crypto.binance.models.NewOrder;

public interface Trade {
    public NewOrder SwapLimitBuyOpen(String cointype, String Price, String amount, int leverage);
    public NewOrder SwapLimitSellClose(String cointype, String Price,String amount, int leverage);
    public NewOrder SwapMarketBuyOpen(String cointype,String amount, int leverage);
    public NewOrder SwapMarketSellClose(String cointype,String amount, int leverage);
    public NewOrder SwapLimitSellOpen(String cointype,String Price,String amount, int leverage);
    public NewOrder SwapLimitBuyClose(String cointype, String Price,String amount,int leverage);
    public NewOrder SwapMarketSellOpen(String cointype, String amount, int leverage);
    public NewOrder SwapMarketBuyClose(String cointype, String amount,int leverage);
}
