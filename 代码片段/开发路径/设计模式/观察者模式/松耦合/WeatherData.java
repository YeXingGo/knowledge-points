package 松耦合;

import java.util.ArrayList;

import javax.xml.transform.Templates;

/**
 * 天气主体对象  1 对 多个 天气观察者
 * @author Lenovo
 *
 */
public class WeatherData implements Subject {
	private ArrayList<Observer> observers;
	private float temperaure;
	private float humidity;
	private float pressure ;
	
	@Override
	public void registerObserver(Observer observer) {
		observers = new ArrayList<Observer>();
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if(i >= 0) {
			observers.remove(observer);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(temperaure, humidity, pressure);
		}
	}
	/**
	 * 通知 观察者数据发生改变
	 */
	public void measurementsChanged() {
		notifyObserver();
	}
	/**
	 * 当主体的数据发生改变的操作方法
	 * @param temperaure
	 * @param humidity
	 * @param pressure
	 */
	public void setMeasurements(float temperaure,float humidity, float pressure) {
		this.temperaure = temperaure;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	public static void main(String[] args) {
		String a = "hello";
		String b = a ;
		System.out.println(a == b);
		b = "world";
		System.out.println( a == b);
		System.out.println(a);
		System.out.println(b);
		
		int c = 5;
		switch (c) {
		case 5:
			System.out.println(5);
		case 1:
			System.out.println(1);
		default:
			System.out.println("default");
			break;
		}
	
	}

}
