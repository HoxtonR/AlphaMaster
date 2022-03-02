package com.hoxtonr.function.spot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("status")
    private String status;
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
    @JsonProperty("IcebergQty")
    private Long IcebergQty;
    @JsonProperty("OrigQuoteOrderQty")
    private Long OrigQuoteOrderQty;
    @JsonProperty("type")
    private String type;
    @JsonProperty("stopPrice")
    private String stopPrice;
    @JsonProperty("side")
    private String side;
    @JsonProperty("market")
    private String market;
    @JsonProperty("positionSide")
    private String positionSide;
    @JsonProperty("leverage")
    private int leverage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public Long getTime() {
        return Time;
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

    public Long getIcebergQty() {
        return IcebergQty;
    }

    public void setIcebergQty(Long icebergQty) {
        IcebergQty = icebergQty;
    }

    public Long getOrigQuoteOrderQty() {
        return OrigQuoteOrderQty;
    }

    public void setOrigQuoteOrderQty(Long origQuoteOrderQty) {
        OrigQuoteOrderQty = origQuoteOrderQty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }
}
