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
	// 函数内声明 变量 x和 y 为外部变量 ,不带有空间，所以不可以赋值
	extern int x ;
	extern int y ;

	// 给外部变量(全部变量) x 和 y 赋值
	x = 1;
	y = 2;

	return x + y;
}




void test_Double() {

	printf("HelloWord\nfdafasfdsafd");
	printf("HelloWord\nfdafasfdsafd");
	printf("int 存储大小: %lu \n %p",sizeof(int),123);

	int a = 10;
	printf("\nd: %d",a); //以十进制形式输出带符号整数
	printf("\nu: %u",a); //以十进制形式输出无符号整数
	printf("\no: %o",a); // 以八进制形成无符号整数 （不输出前缀0）
	printf("\nx: %x",a); // 以十六进制形式输出无符号整数 （不输出 ox） 小写
	printf("\nX: %X",a); // 以十六进制形式输出无符号整数 （不输出 ox） 大写

	printf("\ne: %e",a); // 以指数形式输出单精度实数
	printf("\nE: %E",a); //以指数形式输出双精度实数



	printf("\nc: %c",a); //输出单个字符
	printf("\ns: %s",a+""); //输出字符串
}
