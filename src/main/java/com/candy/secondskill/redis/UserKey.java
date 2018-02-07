package com.candy.secondskill.redis;

public class UserKey extends BasePrefix {
    public UserKey(int expireSeconeds, String preFix) {
        super(expireSeconeds, preFix);
    }

    public UserKey(String prefix) {
        super(prefix);
    }

    public static UserKey getById = new UserKey("id");
    public static UserKey getByName = new UserKey("name");
}
