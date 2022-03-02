package com.hoxtonr.robot.binanceblog;

import com.alibaba.fastjson.JSONArray;
import com.hoxtonr.robot.binanceblog.model.BinanceBlog;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BlogListener {
    private final String url = "https://www.binance.com/en/blog";
    OkHttpClient client;
    final Request request;
    public BlogListener(){
        client = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .build();
    }
    public List<BinanceBlog> getBlog() {
        try {
            Call call = client.newCall(request);
            Response response = call.execute();
            String c = response.body().string();
            String temp = c.substring(c.indexOf("blogList\":[")).replace("blogList\":", "");
            JSONArray array = JSONArray.parseArray(temp.substring(0, temp.indexOf(",\"pinnedPosts")));
            List<BinanceBlog> blogList = new ArrayList<>();
            for(int i = 0; i< array.size();i++){
                BinanceBlog b = new BinanceBlog();
                b.setTitle(array.getJSONObject(i).getString("title"));
                b.setBrief(array.getJSONObject(i).getString("brief"));
                b.setPicUrl(array.getJSONObject(i).getJSONObject("banner").toJSONString());
                b.setPostTime(array.getJSONObject(i).getLong("postTime"));
                b.setCreateTime(array.getJSONObject(i).getLong("createTime"));
                blogList.add(b);
            }
            return blogList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        BlogListener b = new BlogListener();
        System.out.println(b.getBlog());
    }
}