package com.hoxtonr.function.future.market;

import com.hoxtonr.function.future.model.FundingRate;
import com.hoxtonr.function.spot.model.CandleStick;

import java.math.BigDecimal;
import java.util.List;

public class FTXSwapMarket implements Market{
    @Override
    public BigDecimal getPrice(String cointype) {
        return null;
    }

    @Override
    public List<CandleStick> getCandleStick(String cointype) {
        return null;
    }

    @Override
    public List<FundingRate> getFundingRate(String cointype) {
        return null;
    }
}
