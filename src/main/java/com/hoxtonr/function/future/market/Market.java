package com.hoxtonr.function.future.market;

import com.hoxtonr.function.future.model.FundingRate;

import java.math.BigDecimal;
import java.util.List;

public interface Market {
    public BigDecimal getPrice(String cointype);

    public List<com.hoxtonr.function.spot.model.CandleStick> getCandleStick(String cointype);

    public List<FundingRate> getFundingRate(String cointype);
}
