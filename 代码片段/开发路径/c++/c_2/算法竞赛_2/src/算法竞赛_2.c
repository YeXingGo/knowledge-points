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
#include <math.h>


// ���� 1-2 ���㲢��� 8/5 ��ֵ�� ����С�����һλ
void test1_2 () {
	printf("%.1f\n",8.0/5.0);
	//.2 ������λС��
	printf("%.2f\n",8.0/5.0);
	printf("%.1f\n",8/5);
	printf("%d\n",8.0/5.0);
	printf("%d\n",8/5);
}
/**
 *  ���� 1-3 ���ӵı��ʽ����
 */
void test1_3 () {
	// sqrt ƽ����
	printf("%.1f\n",sqrt(9));
	printf("%.8f\n", 1+2 * sqrt(3) / (5 - 0.1));
}
/**
 * 1-4 a + b ����(��������   &)
 */
void  testInput1_4 () {
	int a, b ;
	scanf("%d%d",&a,&b);
	printf("%d\n", a + b);
}

/**
 *  ��λ����ת
 */
void test_T1_3_1 ();
void test_T1_3_2 () ;


/**
 * ��������
 */
void test_T1_1_3_1 ();


/**
 * ����ͬ��
 */
void test_T1_1_11_1 ();

/**
 * ����������
 */
void test_T1_1_13_1 ();
int main(void) {
	test_T1_1_13_1();
	return 0;
}
