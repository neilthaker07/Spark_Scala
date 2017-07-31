package sample.project.sparkJava;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Rule Engine", description = "Weather")
public class RuleEngine {

	private int temperature;
	private int pressure;
	private int id;

	@Condition
	public boolean checkInput() {
		return temperature <= 5 && pressure <= 5;
	}

	@Action
	public void weather() throws Exception {
		System.out.println("Safe weather for ID : " + id);
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	
	public void setPressure(int l) {
		this.pressure = l;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
