package com.example.administrator.oschina.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.ArrayList;
import java.util.List;

/**
 * TweetLikeUserList.java
 * 
 * @author 火蚁(http://my.oschina.net/u/253900)
 *
 * @data 2015-3-26 下午4:23:32
 */
@SuppressWarnings("serial")
@XStreamAlias("oschina")
public class TweetLikeUserList implements ListEntity<com.example.administrator.oschina.bean.User> {
    
    @XStreamAlias("likeList")
    private List<com.example.administrator.oschina.bean.User> list = new ArrayList<com.example.administrator.oschina.bean.User>();

    public List<com.example.administrator.oschina.bean.User> getList() {
        return list;
    }

    public void getList(List<com.example.administrator.oschina.bean.User> list) {
        this.list = list;
    }
}

