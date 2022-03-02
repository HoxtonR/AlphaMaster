package com.hoxtonr.function.future.trade;

import com.client.RequestOptions;
import com.client.SyncRequestClient;
import com.client.model.enums.*;
import com.client.model.trade.Order;
import com.hoxtonr.function.spot.model.NewOrder;

public class BinanceSwapTrade implements Trade{
    private final String apikey;
    private final String secretkey;
    public BinanceSwapTrade(String apikey, String secretkey){
        this.apikey = apikey;
        this.secretkey = secretkey;
    }
    @Override
    public NewOrder SwapLimitBuyOpen(String cointype, String Price, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.BUY, PositionSide.LONG, OrderType.LIMIT, TimeInForce.GTC,
                amount,Price, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapLimitSellClose(String cointype, String Price, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.SELL, PositionSide.LONG, OrderType.LIMIT, TimeInForce.GTC,
                amount,Price, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapMarketBuyOpen(String cointype, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.BUY, PositionSide.LONG, OrderType.MARKET, null,
                amount, null, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;

    }

    @Override
    public NewOrder SwapMarketSellClose(String cointype, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.SELL, PositionSide.LONG, OrderType.MARKET, null,
                amount, null, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapLimitSellOpen(String cointype, String Price, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.SELL, PositionSide.SHORT, OrderType.LIMIT, TimeInForce.GTC,
                amount,Price, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapLimitBuyClose(String cointype, String Price, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.BUY, PositionSide.SHORT, OrderType.LIMIT, TimeInForce.GTC,
                amount,Price, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapMarketSellOpen(String cointype, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.SELL, PositionSide.SHORT, OrderType.MARKET, null,
                amount, null, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }

    @Override
    public NewOrder SwapMarketBuyClose(String cointype, String amount, int leverage) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(apikey, secretkey,
                options);
        syncRequestClient.changeInitialLeverage(cointype,leverage);
        Order o = syncRequestClient.postOrder(cointype, OrderSide.BUY, PositionSide.SHORT, OrderType.MARKET, null,
                amount, null, null, null, null, null, NewOrderRespType.RESULT);
        NewOrder order = new NewOrder();
        order.setMarket("USDT永续合约");
        order.setSymbol(o.getSymbol());
        order.setType(o.getType());
        order.setOrderId(o.getOrderId());
        order.setSide(o.getSide());
        order.setOrigQty(o.getOrigQty().toString());
        order.setPrice(o.getPrice().toString());
        order.setTime(o.getUpdateTime());
        order.setPositionSide(o.getPositionSide());
        order.setLeverage(leverage);
        return order;
    }
}
