//============================================================================
// Name        : TEST.cpp
// Author      :
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void Test_Input_Out() ;


int main() {
	printf("Hello World  ss");
	Test_Input_Out();
	return 0;
}

int test1HelloWolrd() {
	cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
	cout << "HelloWorld\n";
	return 0;
}

int test_D_C() {
	/**
	 *  %c 是表示 char
	 *  %d 标识 double
	 *  \n 换行
	 */
	char c1, c2;
	c1 = 'a';
	c2 = 'b';
	int i1, i2;
	printf("%c,%d\n%c，%d", c1, c1, c2, c2);
	return 0;
}


void Test_Input_Out() {
	int iInput ;
	cout << "Please input a number \n ";
	cin >> iInput;
	cout << "the number is :" << iInput;
}
