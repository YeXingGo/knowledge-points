## 创建tomcat启动脚本

```
*脚本创建路径
	vi /etc/init.d/tomcat 
*注意这个路径是tomcat的路径
	/opt/java/tomcat8/bin

______________________________________________________
# !/bin/bash    
# Description: start or stop the tomcat    
# Usage:        tomcat [start|stop|restart]    
#    
export PATH=$PATH:$HOME/bin  
export BASH_ENV=$HOME/.bashrc  
export USERNAME="root"  
  
case "$1" in  
start)  
#startup the tomcat    
cd /opt/java/tomcat8/bin  
./startup.sh  
;;  
stop)  
# stop tomcat    
cd /opt/java/tomcat8/bin  
./shutdown.sh  
echo "Tomcat Stoped"  
;;  
restart)  
$0 stop  
$0 start  
;;  
*)  
echo "tomcat: usage: tomcat [start|stop|restart]"  
exit 1  
esac  
exit 0  

_______________________________

*创建软连接
cd /usr/bin
ln -s /etc/init.d/tomcat

*测试
tomcat start 启动
tomcat stop
tomcat restart
```