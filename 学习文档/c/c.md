## 看到的位置







## C程序结构

```
1. 编译 & 执行 C 程序
	编译成 main.exe  
    	gcc hello.c  -o main
	执行 
    	main
    	
2. %    	
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
```

## C变量

```
1. 类型
	char   通常是一个字节 （8位）
	float  单精度 1位符号  8位指数 23位小数
	double 双精度 1位符号	 11位指数 52位小数
```

## C操作

```
1. 一个项目中只能有一个 main 方法
	1.声明常量 (常量后边不可以加 ;) #define
		#define NEWLINE '\n'
	2.引入外部变量  extern
		extern int x ;
		extern void funcation();
	3.生成指定常量 const
		const 
	4. 使用 static 的变量 
		不能被 extern 引入
	5. 条件为0 则是false	
```

