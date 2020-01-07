/*
 ============================================================================
 Name        : Test_c_1.c
 Author      : 
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
//#include <stdlib.h>
int x = 1;
int y = 2 ;

int count = 10;

int addTwonum ();

void testDetifier ();

void testConst ();

void func1 ();


void testMethod () {
	int result;
	result = addTwonum();
	printf("%d\n",result);
	//	testDetifier();

	//testConst();
	while (count --) {
		// 测试静态变量
		func1();

	}
}

int main() {
	int num;

	printf("输入一个数字 : ");
	printf("输入一个数字 : ");
	scanf("%d",&num);

	(num%2==0)?printf("偶数"):printf("奇数");

	return 0;
}


