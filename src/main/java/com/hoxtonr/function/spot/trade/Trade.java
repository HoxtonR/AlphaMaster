package com.hoxtonr.function.spot.trade;

import com.hoxtonr.function.spot.model.NewOrder;
import com.hoxtonr.function.spot.model.Order;

import java.math.BigDecimal;

public interface Trade {
    public NewOrder spotLimitBuy(String cointype, BigDecimal amount, BigDecimal price);
    public NewOrder spotLimitSell(String cointype, BigDecimal amount, BigDecimal price);
    public NewOrder spotMarketBuy(String cointype, BigDecimal amount);
    public NewOrder spotMarketSell(String cointype, BigDecimal amount);
    public Order searchOrder(String cointype, Long orderID);
    public Boolean cancelOrder(String cointype,Long orderID);
}
