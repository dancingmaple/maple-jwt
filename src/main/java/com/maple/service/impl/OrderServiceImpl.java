package com.maple.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maple.entity.Order;
import com.maple.enums.OrderAction;
import com.maple.enums.OrderType;
import com.maple.mapper.OrderMapper;
import com.maple.model.OrderModel;
import com.maple.service.IOrderService;
import com.maple.service.handler.OrderHandler;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单主表，当前表只保存流转中的订单信息 服务实现类
 * </p>
 *
 * @author liugh
 * @since 2018-10-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {


    @Override
    public Order handleOrder(OrderAction action, OrderType orderType, OrderModel orderDef) throws Exception {
        Order order = OrderHandler.handle(action, orderType, orderDef);
        return order;
    }

}
