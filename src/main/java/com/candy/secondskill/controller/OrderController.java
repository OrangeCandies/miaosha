package com.candy.secondskill.controller;

import com.candy.secondskill.domain.MiaoShaUser;
import com.candy.secondskill.domain.OrderInfo;
import com.candy.secondskill.redis.RedisServer;
import com.candy.secondskill.result.CodeMsg;
import com.candy.secondskill.result.Result;
import com.candy.secondskill.service.GoodsService;
import com.candy.secondskill.service.MiaoshaUserService;
import com.candy.secondskill.service.OrderService;
import com.candy.secondskill.vo.GoodsVo;
import com.candy.secondskill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private MiaoshaUserService userService;

    @Autowired
    private RedisServer redisService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(Model model, MiaoShaUser user,
                                      @RequestParam("orderId") long orderId) {
        if(user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        OrderInfo order = orderService.getOrderById(orderId);
        if(order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }
}
