package 松耦合;
/**
 * 观察者
 * @author Lenovo
 *
 */
public class CurrentConditionssDisplay implements Observer , DisplayElement{
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	 public CurrentConditionssDisplay(Subject subject) {
		 subject.registerObserver(this);
		 this.weatherData = subject;
	}
	@Override
	public void display() {
		System.out.println(temperature +" " + humidity);
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}

}
