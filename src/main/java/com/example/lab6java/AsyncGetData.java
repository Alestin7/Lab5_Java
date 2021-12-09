package com.example.lab6java;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class AsyncGetData extends Thread {
    private String url = "";
    Cat object = new Cat();

    public void setUrl(String url) {
        this.url = url;
    }

    public Cat getObject() {
        return object;
    }

    public void loadByURL() throws IOException {

        StringBuilder jsonIn = new StringBuilder();
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            int cp;
            while ((cp = rd.read()) != -1) {
                jsonIn.append((char) cp);
            }
        }
        try {
            //object = JSON.parseObject(jsonIn.toString().strip(),Cat.class);
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(jsonIn.toString());
            object.setWebpurl((String) obj.get("webpurl"));
            object.setUrl((String) obj.get("url"));
           //todo cast to int dont working
            object.setId((Integer) obj.get("id"));
            object.setX((Double) obj.get("x"));
            object.setY((Double) obj.get("y"));
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    @Override
    public void run() {

        try {
            loadByURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
