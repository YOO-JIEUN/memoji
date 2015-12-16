package com.yoojieun.memoji.models;

import io.realm.RealmObject;

/**
 * Created by yoojieun on 2015. 11. 20..
 */
public class Memo extends RealmObject {

    private String title;
    private String memo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
