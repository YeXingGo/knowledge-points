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
 *  鸡兔同笼
 *  	n 代表 鸡 兔 总数量
 *  	m 代表多少个腿
 *  	a 鸡
 * 		b 兔
 */

void test_T1_1_11_1() {
	int a,b,n,m;
	scanf("%d%d",&n,&m);
	a = (4 * n - m) / 2;
	b = n - a;
	if (m % 2 == 1 || a < 0 || b < 0 ) {
		printf("No answer \n");
	}
	else {
		printf("%d %d\n",a,b);
	}

}


