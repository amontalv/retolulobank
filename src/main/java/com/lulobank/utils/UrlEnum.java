package com.lulobank.utils;

public enum UrlEnum {

    URI_USER_CREATE("/v2/user"),
    URI_GET_USER("/v2/user/");


    private String value;

    UrlEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
