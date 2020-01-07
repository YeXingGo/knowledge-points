package com.zh.代理.分库分表;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @描述： TODO 切换数据源的代理类
 * @作者: Light
 * @时间: 2019/10/29  23:06
 * @版本：
 */
public class OrderServiceSaticProxy implements  IOrderService{
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceSaticProxy (IOrderService orderService) {
        this.orderService = orderService;
    }


    @Override
    public int createOrder(Order order) {
        before();
        Long createTime = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(createTime)));
        System.out.println("静态代理类自动分配到【DB_" + dbRouter + "】 数据源处理数据");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void before() {
        System.out.println("Proxy before method. ");
    }
    private void after () {
        System.out.println("Proxy after method.");
    }

    public static void main(String[] args) {
        try {
            Order order = new Order();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = simpleDateFormat.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            IOrderService orderService = new OrderServiceSaticProxy(new OrderService());
            orderService.createOrder(order);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
