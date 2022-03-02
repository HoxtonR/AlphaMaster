package com.hoxtonr.function.spot.market;

import com.hoxtonr.function.spot.model.CandleStick;

import java.math.BigDecimal;
import java.util.List;

public interface Market {

    public BigDecimal getPrice(String cointype);

    public List<CandleStick> getCandleStick(String cointype);


}
