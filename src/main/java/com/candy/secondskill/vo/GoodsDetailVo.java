package com.candy.secondskill.vo;

import com.candy.secondskill.domain.MiaoShaUser;

public class GoodsDetailVo {
    private int miaoshaStatus = 0;
    private int remainSeconds= 0;
    private GoodsVo goods ;
    private MiaoShaUser user;
    public int getMiaoshaStatus() {
        return miaoshaStatus;
    }
    public void setMiaoshaStatus(int miaoshaStatus) {
        this.miaoshaStatus = miaoshaStatus;
    }
    public int getRemainSeconds() {
        return remainSeconds;
    }
    public void setRemainSeconds(int remainSeconds) {
        this.remainSeconds = remainSeconds;
    }
    public GoodsVo getGoods() {
        return goods;
    }
    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }
    public MiaoShaUser getUser() {
        return user;
    }
    public void setUser(MiaoShaUser user) {
        this.user = user;
    }
}
