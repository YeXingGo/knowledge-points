##  forEach
```
 注意：
 	1.想使用forEach必须实现 Iterable接口
 	2.必须要有一个Iterator的实现类
 
 使用forEach调用步骤
	1. 调用 iteator方法
	2. 调用 iteator中的 hasNext方法
	3. 调用 iterator中的next方法
	
```
## 泛型
```
	1. 泛型的赋值有两种方式
		1. 类
		2. 方法
	
	2. 类声明方式：
		public static <T> T getListObject (List<? extends T> list) {
            return list != null && list.size() > 0 
            ? (T) list.get(0) : null;
   		}
	3. 方法声明方式：
		public static <T> T getListObject (List<T> list) {
            return list != null && list.size() > 0 
            ? (T) list.get(0) : null;
   		}
   
   泛型针对类与方法之间的关系
   
   想使用泛型 
   			static方法：
   				只有在方法上加上 <T>, 而本T 的作用范围为 本方法
   			普通方法和构造方法
   				可以在方法上加上<T> 也可以在类上添加 <T>, 
   				如果是类上添加的，只能通过new 指定  ，T 的默认值是Object， 不然就是默认值
                【猜测】 现不知道 通过 构造和 方法可以设置 T的值吗
   
```