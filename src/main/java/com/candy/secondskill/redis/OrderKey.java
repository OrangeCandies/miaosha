package com.candy.secondskill.redis;

public class OrderKey extends BasePrefix {
    public OrderKey(int expireSeconeds, String preFix) {
        super(expireSeconeds, preFix);
    }

    public OrderKey(String prefix) {
        super(prefix);
    }

    public static OrderKey getMiaoshaOrderByUidGid = new OrderKey("moug");
}
