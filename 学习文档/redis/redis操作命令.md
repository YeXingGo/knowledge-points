## 使用密码登录
```
auth password
```


##   Redis 列表 list (JAVA  中的list)
```
1. 插入  （add）  特点 可以有重复的值
	rpush   key  values 
	
2. lrange 
	用途 ： 获取列表再给定范围上的所有值 
		比如 ： 0 1  那么就是  下标 0 到 下标 1 的数据都会展示出来
			   0 -1 就是 从 下标  0 到 列表最后一个的下表的数据展示
	写法：
		lrange key 0 -1
		lrange key indexBegin indexEnd

3. lindex		
	用途： 取出指定下标的值
    	与 java中的 get 方法一样
    	
    写法： 
    	lindex key index
    	
4. lpop
	用途： 从列表的左端弹出一个值，并返回被弹出的值
		被弹出列表就没有了
	
	写法： 
		lpop key index
```

## Redis 的集合 Set  （和java中 set 相似）
```
1.	sadd
	用途： 将给定元素添加到元素
	注意： 如果添加已存在的值 就不会添加
	写法： sadd key values

2. smembers 
	用途： 返回集合包含的所有元素
	写法： smembers values
	
3. sismember
	用途： 检查给定元素是否存在于集合中
	写法： sismember key values 
	
4. srem
	用途： 如果给定的元素存在于集合中，那么移除这个元素。
	写法： srem key values
```
## Redis的散列  hset
```
1. hset  
	用途： 在散列里面关联起给定的键值对
	写法： hset key filed values
	
2. hget
	用途：获取指定散列键的值
	写法： hget key filed

3. hgetAll 
	用途： 获取散列包含的所有键值对
	写法： hgetAll key 
	
4. hdel
	用途： 如果给定键存在于散列里面，那么移除这个键
	写法： hdel key 
```

## Redis 的有序集合 zset
```
1.  zadd 
	用途：将一个给定分值的成员添加到有序集合里面
	写法： zadd key score values
	
2. zrange
	用途： 根据元素在有序排列中所处的位置，从有序集合获取多个元素
	写法： zrange key beginIndex endIndex 

3. withscores
	显示 分数值  跟于命令后 如 zrange key beginIndex endIndex withscores
	
	
4. zrangeByScores
	用途： 获取有序集合在给定分值范围内的所有元素
    写法： zrangebyscore key   beginScore endScore withScores
    
5. zrem
	用途： 如果给定成员存在于有序集合，那么移除这个成员
```


## Redis String 类型的操作
```
	支持
		字符串
		整数
		浮点数
	命令
		1. incr （只支持 整数）
			incr key-name  将键储存的值加1
		2. decr （只支持 整数）
			dect key-name 将键储存的值减 1
		3. incrby (只支持 整数)
			incrby key-name amount 将键储存的值加上整数 amount
		4. decrby (只支持 整数)
			decrby  key-name amount 将键储存的值减上整数 amount
		5. incrbyfloat (支持 浮点数 整数)
			incrbyfloat key-name amout 将键储存的值减去浮点数 amount
			
			
			
			
			
			
			
			桂花：桂林乌龙：福建安溪
```