package com.zh.代理.分库分表;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/29  22:44
 * @版本：
 */
public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        // 如果使用Spring 应该是自动注入的
        //
        orderDao = new OrderDao();
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用 orderDao 创建订单");
        return orderDao.insert(order);
    }
}
