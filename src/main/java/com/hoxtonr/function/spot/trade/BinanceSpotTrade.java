package com.hoxtonr.function.spot.trade;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceApiException;
import com.hoxtonr.apis.binanceapi.DefaultAccount;
import com.hoxtonr.function.spot.model.NewOrder;
import com.hoxtonr.function.spot.model.Order;
import com.huobi.client.req.trade.OpenOrdersRequest;
import com.huobi.client.req.trade.OrdersRequest;

import java.math.BigDecimal;

import static com.binance.api.client.domain.account.NewOrder.*;


public class BinanceSpotTrade implements Trade{
    public final String apikey;
    public final String secretkey;
    public BinanceSpotTrade(String apikey, String secretkey){
        this.apikey = apikey;
        this.secretkey = secretkey;
    }
    @Override
    public NewOrder spotLimitBuy(String cointype, BigDecimal amount, BigDecimal price) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        NewOrderResponse res = client.newOrder(limitBuy(cointype,TimeInForce.GTC,amount.toString(),price.toString()).newOrderRespType(NewOrderResponseType.FULL));
        NewOrder order = new NewOrder();
        order.setSymbol(res.getSymbol());
        order.setClientOrderId(res.getClientOrderId());
        order.setOrderId(res.getOrderId());
        order.setPrice(res.getPrice());
        order.setOrigQty(res.getOrigQty());
        order.setSide(res.getSide().toString());
        order.setType(res.getType().toString());
        order.setTime(res.getTransactTime());
        return order;
    }

    @Override
    public NewOrder spotLimitSell(String cointype, BigDecimal amount, BigDecimal price) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        NewOrderResponse res = client.newOrder(limitSell(cointype,TimeInForce.GTC,amount.toString(),price.toString()).newOrderRespType(NewOrderResponseType.FULL));
        NewOrder order = new NewOrder();
        order.setSymbol(res.getSymbol());
        order.setClientOrderId(res.getClientOrderId());
        order.setOrderId(res.getOrderId());
        order.setPrice(res.getPrice());
        order.setOrigQty(res.getOrigQty());
        order.setSide(res.getSide().toString());
        order.setType(res.getType().toString());
        order.setTime(res.getTransactTime());
        return order;
    }

    @Override
    public NewOrder spotMarketBuy(String cointype, BigDecimal amount) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        NewOrderResponse res = client.newOrder(marketBuy(cointype,amount.toString()).newOrderRespType(NewOrderResponseType.FULL));
        NewOrder order = new NewOrder();
        order.setSymbol(res.getSymbol());
        order.setClientOrderId(res.getClientOrderId());
        order.setOrderId(res.getOrderId());
        order.setPrice(res.getPrice());
        order.setOrigQty(res.getOrigQty());
        order.setSide(res.getSide().toString());
        order.setType(res.getType().toString());
        order.setTime(res.getTransactTime());
        return order;
    }

    @Override
    public NewOrder spotMarketSell(String cointype, BigDecimal amount) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        NewOrderResponse res = client.newOrder(marketSell(cointype,amount.toString()).newOrderRespType(NewOrderResponseType.FULL));
        NewOrder order = new NewOrder();
        order.setMarket("现货");
        order.setSymbol(res.getSymbol());
        order.setClientOrderId(res.getClientOrderId());
        order.setOrderId(res.getOrderId());
        order.setPrice(res.getPrice());
        order.setOrigQty(res.getOrigQty());
        order.setSide(res.getSide().toString());
        order.setType(res.getType().toString());
        order.setTime(res.getTransactTime());
        return order;
    }

    @Override
    public Order searchOrder(String cointype,Long orderID) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        com.binance.api.client.domain.account.Order o = client.getOrderStatus(new OrderStatusRequest(cointype,orderID));
        Order order = new Order();
        order.setOrderId(o.getOrderId());
        order.setStatus(o.getStatus().toString());
        order.setClientOrderId(o.getClientOrderId());
        order.setOrigQty(o.getOrigQty());
        order.setExecutedQty(o.getExecutedQty());
        order.setIcebergQty(Long.parseLong(o.getIcebergQty()));
        order.setOrigQuoteOrderQty(Long.parseLong(o.getOrigQuoteOrderQty()));
        order.setPrice(o.getPrice());
        order.setSide(o.getSide().toString());
        order.setStopPrice(o.getStopPrice());
        order.setSymbol(o.getSymbol());
        order.setTime(o.getTime());
        order.setType(o.getType().toString());
        return order;
    }

    @Override
    public Boolean cancelOrder(String cointype,Long orderID) {
        try {
            BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey, secretkey);
            BinanceApiRestClient client = factory.newRestClient();
            CancelOrderResponse cancelOrderResponse = client.cancelOrder(new CancelOrderRequest(cointype, orderID));
            System.out.println(cancelOrderResponse);
        } catch (BinanceApiException e) {
            System.out.println(e.getError().getMsg());
            return false;
        }
        return true;
    }



    public static void main(String[] args) {
        Trade trade = new BinanceSpotTrade(DefaultAccount.getInstance().getApikey(),DefaultAccount.getInstance().getSecretkey());
        NewOrder o = trade.spotLimitBuy("ETHBUSD",BigDecimal.valueOf(0.01),BigDecimal.valueOf(3000));
        System.out.println(o);

    }
}
