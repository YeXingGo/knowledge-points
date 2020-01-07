package com.zh.代理.分库分表;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/10/29  22:40
 * @版本：
 */
public class OrderDao {
    public int insert (Order order) {
        System.out.println("OrderDao 创建 Order 成功");
        return 1;
    }
}
