package com.example.lab6java;

import java.io.IOException;
import java.util.ArrayList;


public class Cats extends Cat {

    private int count;
    private final ArrayList<Cat> catList;

    public Cats() {
        count = 0;
        catList = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void addCat(Cat cat) {
        catList.add(cat);
        count++;
    }

    public ArrayList<Cat> getCatList() {
        return catList;
    }

    public void loadURLOnNewThread(String url) throws InterruptedException, IOException {

        AsyncGetData data = new AsyncGetData();
        data.setUrl(url);
        //data.start();
        data.loadByURL();
//        do {
//            Thread.currentThread().join(250);
//
//        }while (data.getObject().getUrl()==null);
        this.addCat(data.getObject());

    }

    @Override
    public String toString() {
        return "Cats{" +
                "catList=" + catList +
                '}';
    }
}
