package com.hoxtonr.crypto.ftx.spot;

import com.hoxtonr.crypto.binance.models.CandleStick;
import com.hoxtonr.crypto.binance.spot.Market;

import java.math.BigDecimal;
import java.util.List;

public class FTXSpotMarket implements Market {
    @Override
    public BigDecimal getPrice(String cointype) {
        return null;
    }

    @Override
    public List<CandleStick> getCandleStick(String cointype) {
        return null;
    }
}
