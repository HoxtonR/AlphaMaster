package com.hoxtonr.function.spot.market;

import com.hoxtonr.function.spot.model.CandleStick;

import java.math.BigDecimal;
import java.util.List;

public class FTXSpotMarket implements Market{
    @Override
    public BigDecimal getPrice(String cointype) {
        return null;
    }

    @Override
    public List<CandleStick> getCandleStick(String cointype) {
        return null;
    }
}
