package 松耦合;
/**
 * 主体对象 用于发布更新消息到观察者
 * @author Lenovo
 *
 */
public interface Subject {
	/**
	 * 注册观察者对象
	 * @param observer
	 */
	public void registerObserver(Observer observer); 
	/**
	 * 删除对应的观察者
	 * @param observer
	 */
	public void removeObserver(Observer observer); 
	/**
	 * 通知观察者消息更新了
	 */
	public void notifyObserver();
}
