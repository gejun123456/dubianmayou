package com.dubianmayou.entity;

/**
 * Created by bruce on 4/5/2015.
 */
public class ResponseMessage {
    public enum Type {
        success, warn, error, info;
    }

    private final Type type;
    private final String text;

    public ResponseMessage(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public ResponseMessage(Type type) {
        this.type = type;
        this.text = "";
    }

    public String getText() {
        return text;
    }

    public Type getType() {
        return type;
    }
}
