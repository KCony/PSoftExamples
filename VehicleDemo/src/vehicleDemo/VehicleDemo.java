package vehicleDemo;

abstract class Vehicle
{
	protected int passengers;
	protected String motor;
	public int getPassengers()	{
		return passengers;
	}
	public void setPassengers(int i) {
		passengers = i;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String string) {
		motor = string;
	}
}

class Automobile extends Vehicle
{
	private String make;
	private String model;
	public String getMake() {
		return make;
	}
	public String getModel() {
		return model;
	}
	public void setMake(String string) {
		make = string;
	}
	public void setModel(String string) {
		model = string;
	}
}

public class VehicleDemo {

	public static void main(String[] args) {

	}

}
