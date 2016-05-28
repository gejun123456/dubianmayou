package com.dubianmayou.dto;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by bruce on 5/29/2016.
 */
public class FollowerDto {

    private String picUrl;

    private String url;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("picUrl", picUrl)
                .append("url", url)
                .append("count", count)
                .toString();
    }


}
