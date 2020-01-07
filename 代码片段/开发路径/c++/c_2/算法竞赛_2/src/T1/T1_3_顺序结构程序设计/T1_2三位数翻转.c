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

/**
 *  输入一个 三个数，分离出 他的百位、十位、个位、反转
 */

void test_T1_3_1() {
	int n;
	scanf("%d", &n);
	printf("%d%d%d\n", n % 10, n /10 % 10 , n /100);
}

/**
 *   第二种
 */
void test_T1_3_2() {
	int n;
	scanf("%d", &n);
	int m = (n % 10) * 100 + (n / 10 % 10) * 10 + (n / 100) ;
	printf("%03d\n", m);
	printf("%02d\n", m);
	printf("%01d\n", m);
}
