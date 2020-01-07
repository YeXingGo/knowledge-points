#include <stdio.h>

extern  int count ;

/**
 * 测试 static 变量
 */
void func1 () {
	static int thingy = 5;

	thingy ++ ;
	printf(" thingy 为 %d, count 为  %d \n",thingy,count);
}
