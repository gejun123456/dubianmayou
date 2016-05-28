package com.dubianmayou.dto;

/**
 * Created by bruce on 5/29/2016.
 */
public class FollowerDtoBuilder {
    private int count;
    private String picUrl;
    private String url;

    private FollowerDtoBuilder() {
    }

    public static FollowerDtoBuilder aFollowerDto() {
        return new FollowerDtoBuilder();
    }

    public FollowerDtoBuilder withCount(int count) {
        this.count = count;
        return this;
    }

    public FollowerDtoBuilder withPicUrl(String picUrl) {
        this.picUrl = picUrl;
        return this;
    }

    public FollowerDtoBuilder withUrl(String url) {
        this.url = url;
        return this;
    }

    public FollowerDtoBuilder but() {
        return aFollowerDto().withCount(count).withPicUrl(picUrl).withUrl(url);
    }

    public FollowerDto build() {
        FollowerDto followerDto = new FollowerDto();
        followerDto.setCount(count);
        followerDto.setPicUrl(picUrl);
        followerDto.setUrl(url);
        return followerDto;
    }
}
