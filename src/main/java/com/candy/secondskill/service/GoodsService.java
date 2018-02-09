package com.candy.secondskill.service;

import com.candy.secondskill.dao.GoodsDao;
import com.candy.secondskill.domain.Goods;
import com.candy.secondskill.domain.MiaoshaGoods;
import com.candy.secondskill.vo.GoodsVo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;


    public List<GoodsVo> listGoodsVo(){
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoByGoodsId(long goodsId) {
        return goodsDao.getGoodsVoByGoodsId(goodsId);
    }

    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
        goodsDao.reduceStock(g);
    }

    @Test
    public void testDao() {
        List<Goods> goodsVos = goodsDao.listGoods();
        System.out.println(goodsVos);
    }

}
