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
		// ���Ծ�̬����
		func1();

	}
}

int main() {
	int num;

	printf("����һ������ : ");
	printf("����һ������ : ");
	scanf("%d",&num);

	(num%2==0)?printf("ż��"):printf("����");

	return 0;
}


