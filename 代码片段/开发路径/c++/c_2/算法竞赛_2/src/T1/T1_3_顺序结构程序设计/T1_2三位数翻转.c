/*
 ============================================================================
 Name        : �㷨����_2.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>

/**
 *  ����һ�� ������������� ���İ�λ��ʮλ����λ����ת
 */

void test_T1_3_1() {
	int n;
	scanf("%d", &n);
	printf("%d%d%d\n", n % 10, n /10 % 10 , n /100);
}

/**
 *   �ڶ���
 */
void test_T1_3_2() {
	int n;
	scanf("%d", &n);
	int m = (n % 10) * 100 + (n / 10 % 10) * 10 + (n / 100) ;
	printf("%03d\n", m);
	printf("%02d\n", m);
	printf("%01d\n", m);
}
