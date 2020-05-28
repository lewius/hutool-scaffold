package com.example.hutool;

import cn.hutool.cron.CronUtil;
import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // Scheduler
        CronUtil.start();
    }

    public void run() {
        try {
            // JDBC
            List<Entity> list = Db.use().findAll("pay_order");
            System.out.println(list);

            // HTTP
            HttpRequest request = HttpRequest.get("https://api.qegoo.cn/product/catalog-tree")
                    .header("Content-Type", "application/json");
            HttpResponse response = request.execute();
            String result = response.body();

            // JSON
            JSONArray array = JSONUtil.parseArray(result);
            array.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
