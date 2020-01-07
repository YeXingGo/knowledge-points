package com.zl.design.patterns.lambda;

/**
 * @描述： TODO
 * @作者: Light
 * @时间: 2019/8/27  8:50
 * @版本：
 */
public class HelloWord {
    public static void main(String[] args) {

    }

    public static Calculable calculate(int power) {
        Calculable calculable = null;
        Thread thread = null;
        if (power == 2) {
            // lambda 表达式
            calculable = (int a) -> {
                return a * a;
            };
        }
        else {
            calculable = a -> {
                return a ;
            };
        }

        return calculable;
    }
}
