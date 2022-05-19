package com.hoxtonr.robot.bellwhether;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hoxtonr.crypto.apis.binanceapi.DefaultAccount;
import com.hoxtonr.crypto.binance.spot.BinanceSpotMarket;
import com.hoxtonr.crypto.binance.models.CandleStick;
import com.hoxtonr.tools.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class History {

    public static void main(String[] args) throws IOException {
        History t = new History();
        HashMap<String,Integer[]> s = t.TradeRuleHandler(FileHandler.readFile("BinanceSpotTradeRule.json"));
        BinanceSpotMarket m = new BinanceSpotMarket(DefaultAccount.getInstance().getApikey(), DefaultAccount.getInstance().getSecretkey());
        List<String> coin = new ArrayList<>();
        for(String c : s.keySet()){
            List<CandleStick> cand = m.getCandleStick(c);
            System.out.println("查询"+c+"中");
            int i = 0;
            for(CandleStick tempCandleStick : cand){
                if(tempCandleStick.getHigh()>tempCandleStick.getOpen()*2&&i!=0&&i!=cand.size()-1){
                  coin.add(c);
                  System.out.println(c+"已加入名单！");
                  break;
                }
                i++;
            }
        }
        System.out.println(coin);

    }
    public HashMap<String,Integer[]> TradeRuleHandler(String BinanceSpotTradeRule) {
        HashMap<String,Integer[]> spotTradeRuleHash = new HashMap<>();
        JSONObject BinSpotTradeRule = JSONObject.parseObject(BinanceSpotTradeRule);
        JSONArray coinlist = JSONArray.parseArray(BinSpotTradeRule.getString("symbols"));
        for(int i = 0; i<coinlist.size();i++){
            Integer[] mainhash = new Integer[2];
            JSONArray o = coinlist.getJSONObject(i).getJSONArray("filters");
            for(int j = 0;j<o.size();j++){
                JSONObject m = o.getJSONObject(j);
                if(m.getString("filterType").equals("LOT_SIZE")){
                    String c = m.getString("stepSize");
                    int decimal = c.indexOf("1")-c.indexOf(".");
                    if(decimal>0){
                        mainhash[0] = decimal;
                    }else{
                        mainhash[0] = 0;
                    }
                }
                if(m.getString("filterType").equals("PRICE_FILTER")){
                    String c = m.getString("tickSize");
                    int decimal = c.indexOf("1")-c.indexOf(".");
                    if(decimal>0){
                        mainhash[1] = decimal;
                    }else{
                        mainhash[1] = 0;
                    }
                }
            }
            spotTradeRuleHash.put(coinlist.getJSONObject(i).getString("symbol"),mainhash);
        }
        return spotTradeRuleHash;
    }
}
