package com.candy.secondskill.redis;

public interface KeyPrefix {

    public int expireSeconds();

    public String getPrefix();

}