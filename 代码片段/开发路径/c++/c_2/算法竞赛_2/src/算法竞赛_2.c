/*
 ============================================================================
 Name        : 算法竞赛_2.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <math.h>


// 程序 1-2 计算并输出 8/5 的值， 保留小数点后一位
void test1_2 () {
	printf("%.1f\n",8.0/5.0);
	//.2 保留两位小数
	printf("%.2f\n",8.0/5.0);
	printf("%.1f\n",8/5);
	printf("%d\n",8.0/5.0);
	printf("%d\n",8/5);
}
/**
 *  程序 1-3 复杂的表达式计算
 */
void test1_3 () {
	// sqrt 平方根
	printf("%.1f\n",sqrt(9));
	printf("%.8f\n", 1+2 * sqrt(3) / (5 - 0.1));
}
/**
 * 1-4 a + b 问题(键盘输入   &)
 */
void  testInput1_4 () {
	int a, b ;
	scanf("%d%d",&a,&b);
	printf("%d\n", a + b);
}

/**
 *  三位数翻转
 */
void test_T1_3_1 ();
void test_T1_3_2 () ;


/**
 * 变量交换
 */
void test_T1_1_3_1 ();


/**
 * 鸡兔同笼
 */
void test_T1_1_11_1 ();

/**
 * 三整数排序
 */
void test_T1_1_13_1 ();
int main(void) {
	test_T1_1_13_1();
	return 0;
}
