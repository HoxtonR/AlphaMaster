package com.hoxtonr.function.spot.market;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.hoxtonr.apis.binanceapi.DefaultAccount;
import com.hoxtonr.function.spot.model.CandleStick;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BinanceSpotMarket implements Market{
    public final String apikey;
    public final String secretkey;
    public BinanceSpotMarket(String apikey, String secretkey){
        this.apikey = apikey;
        this.secretkey = secretkey;
    }
    @Override
    public BigDecimal getPrice(String cointype) {
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey,secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        return BigDecimal.valueOf(Long.parseLong(client.getPrice(cointype).getPrice()));
    }
    @Override
    public List<CandleStick> getCandleStick(String cointype) {
        List<CandleStick> ca = new ArrayList<>();
        BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance(apikey,secretkey);
        BinanceApiRestClient client = factory.newRestClient();
        List<Candlestick> candlesticks = client.getCandlestickBars(cointype, CandlestickInterval.DAILY);
        for(Candlestick c : candlesticks){
            CandleStick cs = new CandleStick();
            cs.setOpen(Double.parseDouble(c.getOpen()));
            cs.setClose(Double.parseDouble(c.getClose()));
            cs.setHigh(Double.parseDouble(c.getHigh()));
            cs.setLow(Double.parseDouble(c.getLow()));
            cs.setCloseTime(c.getCloseTime());
            cs.setOpenTime(c.getOpenTime());
            ca.add(cs);
        }
        return ca;
    }

    public static void main(String[] args){
        BinanceSpotMarket market = new BinanceSpotMarket(DefaultAccount.getInstance().getApikey(),DefaultAccount.getInstance().getSecretkey());

    }
}
