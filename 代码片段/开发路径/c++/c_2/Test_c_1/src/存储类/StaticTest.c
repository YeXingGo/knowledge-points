#include <stdio.h>

extern  int count ;

/**
 * ���� static ����
 */
void func1 () {
	static int thingy = 5;

	thingy ++ ;
	printf(" thingy Ϊ %d, count Ϊ  %d \n",thingy,count);
}
