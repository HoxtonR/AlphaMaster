package com.hoxtonr.crypto.binance.swap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.client.RequestOptions;
import com.client.SyncRequestClient;
import com.client.model.enums.CandlestickInterval;
import com.client.model.market.Candlestick;
import com.hoxtonr.crypto.apis.binanceapi.DefaultAccount;
import com.hoxtonr.crypto.binance.models.CandleStick;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BinanceSwapMarket implements Market {
    @Override
    public BigDecimal getPrice(String cointype) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(DefaultAccount.getInstance().getApikey(),DefaultAccount.getInstance().getSecretkey(),
                options);
        return syncRequestClient.getMarkPrice(cointype).get(0).getMarkPrice();
    }


    @Override
    public List<CandleStick> getCandleStick(String cointype, CandlestickInterval cvl) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(DefaultAccount.getInstance().getApikey(),DefaultAccount.getInstance().getSecretkey(),
                options);
        List<Candlestick> cand = syncRequestClient.getCandlestick(cointype, cvl, null, null, 5);
        List<CandleStick> candleStick = new ArrayList<>();
        for(Candlestick c : cand){
            CandleStick cc = new CandleStick();
            cc.setClose(c.getClose().doubleValue());
            cc.setOpen(c.getOpen().doubleValue());
            cc.setHigh(c.getHigh().doubleValue());
            cc.setLow(c.getLow().doubleValue());
            cc.setVolume(c.getVolume().doubleValue());
            cc.setOpenTime(c.getOpenTime());
            cc.setCloseTime(c.getCloseTime());
            cc.setCointype(cointype);
            candleStick.add(cc);

        }
        return candleStick;
    }

    @Override
    public List<FundingRate> getFundingRate(String cointype) {
        String url = "https://fapi.binance.com/fapi/v1/premiumIndex";
        List<FundingRate> rate = new ArrayList<>();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            String c = response.body().string();
            JSONArray array = JSONArray.parseArray(c);

        for(int i = 0;i<array.size();i++) {
            JSONObject j = array.getJSONObject(i);
            FundingRate newrate = new FundingRate();
            newrate.setEstimatedSettlePrice(j.getString("estimatedSettlePrice"));
            newrate.setSymbol(j.getString("symbol"));
            newrate.setMarkPrice(j.getString("markPrice"));
            newrate.setIndexPrice(j.getString("indexPrice"));
            newrate.setTime(j.getLong("time"));
            newrate.setNextFundingTime(j.getLong("nextFundingTime"));
            newrate.setInterestRate(j.getString("interestRate"));
            newrate.setLastFundingRate(j.getString("lastFundingRate"));
            rate.add(newrate);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        QuickSortRate(rate);
        return rate;
    }

    public void QuickSortRate(List<FundingRate> r){
        FundingRate temp;
        for (int i = 0; i < r.size(); i++) {
            for (int j = 0; j < r.size() - i - 1 ; j++) {
                if (Double.parseDouble(r.get(j+1).getLastFundingRate())<Double.parseDouble(r.get(j).getLastFundingRate())) {
                    temp = r.get(j);
                    r.set(j,r.get(j+1));
                    r.set(j+1,temp);
                }
            }
        }
    }
    public static void main(String[] args) {
        BinanceSwapMarket market = new BinanceSwapMarket();
        System.out.println(market.getPrice("BTCUSDT"));
    }
}
