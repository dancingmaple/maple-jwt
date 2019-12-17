package com.maple.service.handler;

import com.maple.entity.Order;
import com.maple.enums.OrderAction;
import com.maple.enums.OrderType;
import com.maple.model.OrderModel;
import com.maple.service.processor.ActionProcessor;
import org.springframework.stereotype.Component;

/**
 * @author liugh
 * @since 2018-10-17
 */
@Component("ProductOrderHandler")
public class ProductOrderHandler extends OrderHandler {

	@Override
	public Order handleInternal(OrderAction action, OrderType orderType, OrderModel orderDef, Order currentOrder) throws Exception {
		return  ActionProcessor.process(action,orderType,orderDef,currentOrder);
	}
}
