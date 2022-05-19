package com.hoxtonr.crypto.binance.swap;

public interface Account {
    public String BinanceSwapBalance(String cointype);
    public String BinanceSwapShortBalance(String cointype);
    public String BinanceSwapUsdt();
    public String getSwapTransferBalance();
    public void getPositions();
}
