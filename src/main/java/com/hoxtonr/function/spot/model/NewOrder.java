package com.hoxtonr.function.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor
@Data
public class NewOrder {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("orderListId")
    private Long orderListId;
    @JsonProperty("clientOrderId")
    private String clientOrderId;
    @JsonProperty("Time")
    private Long Time;
    @JsonProperty("price")
    private String price;
    @JsonProperty("origQty")
    private String origQty;
    @JsonProperty("executedQty")
    private String executedQty;
    @JsonProperty("type")
    private String type;
    @JsonProperty("side")
    private String side;
    @JsonProperty("market")
    private String market;
    @JsonProperty("positionSide")
    private String positionSide;
    @JsonProperty("leverage")
    private int leverage;

    public LocalDateTime getTime() {
        Instant ins = Instant.ofEpochMilli(Time);
        return LocalDateTime.ofInstant(ins, ZoneId.systemDefault());
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public void setTime(Long time) {
        Time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrigQty() {
        return origQty;
    }

    public void setOrigQty(String origQty) {
        this.origQty = origQty;
    }

    public String getExecutedQty() {
        return executedQty;
    }

    public void setExecutedQty(String executedQty) {
        this.executedQty = executedQty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("【币安】成功下单,订单编号为：").append(getOrderId()).append(",")
                .append("下单市场为：").append(getMarket()).append(",")
                .append("下单价格为：").append(getPrice()).append(",")
                .append("下单时间为：").append(getTime()).append(",")
                .append("交易方向为：").append(getSide()).append(",")
                .append("交易类型为：").append(getType()).append(",")
                .append("下单数量为：").append(getOrigQty()).append(" ").append(getSymbol().toUpperCase());
        if (getPositionSide() != null) {
            sb.append("多空方向为：").append(getPositionSide()).append(",")
            .append("杠杆倍数为：").append(getLeverage()).append(",");
        }
        sb.append("。");
        return sb.toString();
    }
}
