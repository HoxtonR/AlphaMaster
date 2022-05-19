package com.hoxtonr.robot.upbitblog;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hoxtonr.robot.upbitblog.model.upbitBlog;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class upbitListener {
    final String url = "https://api-manager.upbit.com/api/v1/notic  es?page=1&per_page=20&thread_name=general";
    OkHttpClient client;
    final Request request;
    List<upbitBlog> blogs;
    public upbitListener(){
        client = new OkHttpClient();
        request = new Request.Builder()
                .url(url)
                .build();
        blogs = new ArrayList<>();
    }
    public List<upbitBlog> getBlog() {
        try {
            Call call = client.newCall(request);
            Response response = call.execute();
            String c = response.body().string();
            JSONObject obj1 = JSONObject.parseObject(c);
            JSONArray array1 = obj1.getJSONObject("data").getJSONArray("list");
            for(int i = 0;i < array1.size();i++) {
                upbitBlog blog = new upbitBlog();
                blog.setTitle(array1.getJSONObject(i).getString("title"));
                blog.setCreatedAt(array1.getJSONObject(i).getString("created_at"));
                blog.setUpdatedAt(array1.getJSONObject(i).getString("updated_at"));
                blog.setId(array1.getJSONObject(i).getInteger("id"));
                blogs.add(blog);
            }

            return blogs;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        upbitListener l = new upbitListener();
        System.out.println(l.getBlog());
    }
}
