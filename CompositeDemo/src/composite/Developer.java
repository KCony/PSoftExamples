package composite;

public class Developer implements Employee {

	private String name;
	private double salary;
	private String position = "developer";
	
	Developer(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public void add(Employee employee) {
		//this is leaf node so this method is not applicable to this class.
	}

	@Override
	public void remove(Employee employee) {
		//this is leaf node so this method is not applicable to this class.
	}

	@Override
	public Employee getChild(int i) {
		//this is leaf node so this method is not applicable to this class.
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public String getPosition() {
		return position;
	}

	@Override
	public void print() {
		System.out.println("Employee: " + name + 
				" Salary: " + String.valueOf(salary) +
				" Position: " + position);
	}

}
