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
 * ���������� ��С����
 * �Ȱ���С�ķ��� ��һλ �� ֮��ȽϾ�ֻ�ñȽ� ����λ�Ĵ�С
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


