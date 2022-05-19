package com.hoxtonr.crypto.binance.spot;

import com.hoxtonr.crypto.binance.models.CandleStick;

import java.math.BigDecimal;
import java.util.List;

public interface Market {

    public BigDecimal getPrice(String cointype);

    public List<CandleStick> getCandleStick(String cointype);


}
