package com.thevarungupta.listview;

import java.util.ArrayList;

public class SampleData {



    public static ArrayList<Item> generateData(){

        ArrayList<Item> list=new ArrayList<>();
        Item item;

        item = new Item();
        item.setTitle("Title 1");
        item.setDescription("Description 1");
        list.add(item);

        item = new Item();
        item.setTitle("Title 2");
        item.setDescription("Description 2");
        list.add(item);

        item = new Item();
        item.setTitle("Title 3");
        item.setDescription("Description 3");
        list.add(item);

        item = new Item();
        item.setTitle("Title 4");
        item.setDescription("Description 4");
        list.add(item);

        return list;

    }

}
