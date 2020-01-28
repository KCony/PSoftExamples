package composite;

import java.util.List;
import java.util.ArrayList;

public class Manager implements Employee{

	private String name;
	private double salary;
	private String position = "manager";
	private List<Employee> employees = new ArrayList<Employee>();

	public Manager(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}

	@Override
	public Employee getChild(int i) {
		return employees.get(i);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPosition() {
		return position;
	}

	@Override
	public void remove(Employee employee) {
		employees.remove(employee); // assume each employee is unique
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public void print() {
		System.out.println("Manager: " + this.getName() + 
				" Salary: " + String.valueOf(this.getSalary()) +
				" Position: " + this.getPosition());
		for(Employee emp : employees) {
//			System.out.println("Employee: " + emp.getName() + 
//					" Salary: " + String.valueOf(emp.getSalary()) +
//					" Position: " + emp.getPosition());
			emp.print();
		}	
	}
}

