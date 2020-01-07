##  liunx
1. 开放端口
	```
	systemctl status firewalld
	systemctl start firewalld
	查询所有
	firewall-cmd --list-all
	开放指定端口
	firewall-cmd --permanent --zone=public --add-port=8080/tcp
	
	firewall-cmd --list-port
	firewall-cmd --reload
	
	
	查看端口被那个进程使用
	netstat -tunlp|grep 端口号
	```
2. 时间操作
    ```
    修改服务器时间为指定时间
    	date  -s "2019-8-14 11:49:00"
    ```

## 部署
```
	1.liunx下创建自己的环境变量
		vim /etc/profile 
	  如： 变量名      =  地址
			Kylin_Dragon_Conf=/usr/local/TeaHouse/config/
		path目录：
			PATH=$PATH:$JAVA_HOME/bin:$Kylin_Dragon_Conf
		
			export PATH JAVA_HOME CLASSPATH  Kylin_Dragon_Conf

	2. tomcat的根目录
	
		/webapps/ROOT 文件
		
	3. 配置tomcat的端口
	
		vim /tomcat/config 
			<Connector port="8080" protocol="HTTP/1.1" 				   										connectionTimeout="20000" redirectPort="8443" />
```

