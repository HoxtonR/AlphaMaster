package com.hoxtonr.crypto.binance.spot;

import com.hoxtonr.crypto.binance.models.NewOrder;
import com.hoxtonr.crypto.binance.models.Order;

import java.math.BigDecimal;

public interface Trade {
    public NewOrder spotLimitBuy(String cointype, BigDecimal amount, BigDecimal price);
    public NewOrder spotLimitSell(String cointype, BigDecimal amount, BigDecimal price);
    public NewOrder spotMarketBuy(String cointype, BigDecimal amount);
    public NewOrder spotMarketSell(String cointype, BigDecimal amount);
    public Order searchOrder(String cointype, Long orderID);
    public Boolean cancelOrder(String cointype,Long orderID);
}
