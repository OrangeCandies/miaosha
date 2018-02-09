package com.candy.secondskill.dao;

import com.candy.secondskill.domain.Goods;
import com.candy.secondskill.domain.MiaoshaGoods;
import com.candy.secondskill.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GoodsDao {
    @Select("select g.*,mg.stockCount, mg.startDate, mg.endDate,mg.miaoshaPrice from miaosha_goods mg left join goods g on mg.gid = g.id")
    public List<GoodsVo> listGoodsVo();

    //todo test
    @Select("SELECT * FROM goods")
    public List<Goods> listGoods();
    @Select("select g.*,mg.stockCount, mg.startDate, mg.endDate,mg.miaoshaPrice from miaosha_goods mg left join goods g on mg.gid = g.id where g.id = #{goodsId}")
    public GoodsVo getGoodsVoByGoodsId(@Param("goodsId")long goodsId);

    @Update("update miaosha_goods set stockCount = stock_count - 1 where gid = #{goodsId} and stock_count > 0")
    public int reduceStock(MiaoshaGoods g);
}
