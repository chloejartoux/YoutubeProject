package com.example.chlo.exam.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chloe on 17/03/2017.
 */

public class Videos {
    private Example example;
    private List<Item> items;

    public Videos(Example example)
    {
        this.example=example;
        items=new ArrayList<>();
    }

    public Example getExample() {
        return example;
    }

    public void setExample(Example example) {
        this.example = example;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
