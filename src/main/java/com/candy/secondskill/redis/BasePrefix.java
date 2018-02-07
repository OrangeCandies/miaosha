package com.candy.secondskill.redis;

public abstract class BasePrefix implements KeyPrefix {

   private int expireSeconeds;
   private String preFix;

    public BasePrefix(int expireSeconeds, String preFix) {
        this.expireSeconeds = expireSeconeds;
        this.preFix = preFix;
    }

    public BasePrefix(String prefix) {//0代表永不过期
        this(0, prefix);
    }

    @Override
    public int expireSeconds() {//默认0代表永不过期
        return expireSeconeds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + preFix;
    }
}
