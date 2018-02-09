package com.candy.secondskill.dao;

import com.candy.secondskill.domain.MiaoshaOrder;
import com.candy.secondskill.domain.OrderInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderDao {

    @Select("select * from miaoshaorder where uid=#{userId} and gid=#{goodsId}")
    public MiaoshaOrder getMiaoshaOrderByUserIdGoodsId(@Param("userId")long userId, @Param("goodsId")long goodsId);

    @Insert("insert into orderinfo(userId, goodsId, goodsName, goodsCount, goodsPrice, orderChannel, status, createDate)values("
            + "#{userId}, #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel},#{status},#{createDate} )")
    @SelectKey(keyColumn="id", keyProperty="id", resultType=long.class, before=false, statement="select last_insert_id()")
    public long insert(OrderInfo orderInfo);

    @Insert("insert into miaoshaorder (user_id, goods_id, order_id)values(#{userId}, #{goodsId}, #{orderId})")
    public int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);

    @Select("select * from orderinfo where id = #{orderId}")
    public OrderInfo getOrderById(@Param("orderId")long orderId);

}
