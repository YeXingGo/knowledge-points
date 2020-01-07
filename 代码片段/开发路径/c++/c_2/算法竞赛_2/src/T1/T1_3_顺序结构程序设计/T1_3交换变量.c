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
 *  1
 */

void test_T1_1_3_1() {
	int a, b ,t ;
	scanf("%d%d",&a,&b);
	t = a;
	a = b;
	b = t;
	printf("%d %d \n",a,b);

}

/**
 *   第二种
 */
void test_T1_1_3_2() {
	int n;
	scanf("%d", &n);
	int m = (n % 10) * 100 + (n / 10 % 10) * 10 + (n / 100) ;
	printf("%03d\n", m);
	printf("%02d\n", m);
	printf("%01d\n", m);
}
