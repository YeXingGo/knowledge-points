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
 * 三整数排序 从小到大
 * 先把最小的放在 第一位 ， 之后比较就只用比较 后两位的大小
 */

void test_T1_1_13_1() {
	int a,b,c,t;
	scanf("%d%d%d",&a,&b,&c);
	if (a > b) {
		t = a;
		a = b;
		b = t;
	}
	if (a > c) {
		t = a;
		a = c;
		c = t;
	}
	if (b > c) {
		t = b;
		b = c;
		c = t;
	}
	printf("%d %d %d",a,b,c);
}


