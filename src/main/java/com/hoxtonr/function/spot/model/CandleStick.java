package com.hoxtonr.function.spot.model;

import java.math.BigDecimal;

public class CandleStick {
    public String cointype;
    public Double open;
    public Double close;
    public Double high;
    public Double low;
    public Double volume;
    public Long openTime;
    public Long closeTime;

    public String getCointype() {
        return cointype;
    }

    public void setCointype(String cointype) {
        this.cointype = cointype;
    }

    public Double getOpen() {
        return open;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public Double getClose() {
        return close;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Long getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Long openTime) {
        this.openTime = openTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append("open: ").append(getOpen()).append(",")
                .append("close: ").append(getClose()).append(",")
                .append("high: ").append(getHigh()).append(",")
                .append("low: ").append(getLow()).append(",")
                .append("openTime: ").append(getOpenTime()).append(",")
                .append("closeTime: ").append(getCloseTime()).append("}");
        return sb.toString();
    }
}
