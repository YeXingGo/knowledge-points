//============================================================================
// Name        : Test-c.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <stdio.h>
int x = 1;
int y ;

int addTwonum ();

int main() {

	int result;
	result = addTwonum();
	printf("%d",result);
	return 0;
}

int addTwonum () {
	// ���������� ���� x�� y Ϊ�ⲿ���� ,�����пռ䣬���Բ����Ը�ֵ
	extern int x ;
	extern int y ;

	// ���ⲿ����(ȫ������) x �� y ��ֵ
	x = 1;
	y = 2;

	return x + y;
}




void test_Double() {

	printf("HelloWord\nfdafasfdsafd");
	printf("HelloWord\nfdafasfdsafd");
	printf("int �洢��С: %lu \n %p",sizeof(int),123);

	int a = 10;
	printf("\nd: %d",a); //��ʮ������ʽ�������������
	printf("\nu: %u",a); //��ʮ������ʽ����޷�������
	printf("\no: %o",a); // �԰˽����γ��޷������� �������ǰ׺0��
	printf("\nx: %x",a); // ��ʮ��������ʽ����޷������� ������� ox�� Сд
	printf("\nX: %X",a); // ��ʮ��������ʽ����޷������� ������� ox�� ��д

	printf("\ne: %e",a); // ��ָ����ʽ���������ʵ��
	printf("\nE: %E",a); //��ָ����ʽ���˫����ʵ��



	printf("\nc: %c",a); //��������ַ�
	printf("\ns: %s",a+""); //����ַ���
}
