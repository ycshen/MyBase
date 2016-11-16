package com.brp.model;

import java.util.List;

/**
 * Created by Administrator on 2016/6/28.
 */
public class SeriesModel {

    public String name;

    public String type;

    public List<Integer> data;

    public SeriesModel() {
    }

    public SeriesModel(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public SeriesModel(String name, String type, List<Integer> data) {
        super();
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }
}
