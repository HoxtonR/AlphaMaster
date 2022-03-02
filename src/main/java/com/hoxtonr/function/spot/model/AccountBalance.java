package com.hoxtonr.function.spot.model;

import java.math.BigDecimal;

public class AccountBalance {
    private String Symbol;
    private BigDecimal Free;
    private BigDecimal Locked;

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public BigDecimal getFree() {
        return Free;
    }

    public void setFree(BigDecimal free) {
        Free = free;
    }

    public BigDecimal getLocked() {
        return Locked;
    }

    public void setLocked(BigDecimal locked) {
        Locked = locked;
    }
    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("{币种: ").append(getSymbol()).append("余额: ").append(getFree()).append(",")
                .append("冻结：").append(getLocked()).append("}");
        return b.toString();
    }
}
