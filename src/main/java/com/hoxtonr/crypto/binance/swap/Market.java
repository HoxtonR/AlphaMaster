package com.hoxtonr.crypto.binance.swap;

import com.client.model.enums.CandlestickInterval;
import com.hoxtonr.crypto.binance.models.CandleStick;

import java.math.BigDecimal;
import java.util.List;

public interface Market {
    public BigDecimal getPrice(String cointype);

    public List<CandleStick> getCandleStick(String cointype, CandlestickInterval cvl);

    public List<FundingRate> getFundingRate(String cointype);
}
