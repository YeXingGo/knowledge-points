package 松耦合;
/**
 * 
 * @author Lenovo
 *
 */
public interface Observer {
	/**
	 * 更新消息    
	 * 策略模式   
	 * 			把容易变化的抽取出来，这样不会影响
	 * @param temp  温度
	 * @param humidity 湿度
	 * @param pressure 气压
	 */
	public void update(float temperaure,float humidity,float pressure);
	//TODO
	//XXX
	//FIXME :if () {} ELSE {}  FOR () {}
	
	
}
